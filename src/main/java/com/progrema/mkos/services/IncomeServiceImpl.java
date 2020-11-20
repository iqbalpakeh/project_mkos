package com.progrema.mkos.services;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import com.progrema.mkos.entities.income.Income;
import com.progrema.mkos.controller.income.wrapper.IncomeWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import com.progrema.mkos.repositories.RevenuePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final RevenuePaymentRepository revenuePaymentRepository;
    private final ExpensePaymentRepository expensePaymentRepository;
    private final TimestampService timestampService;

    public IncomeServiceImpl(RevenuePaymentRepository revenuePaymentRepository,
                             ExpensePaymentRepository expensePaymentRepository,
                             TimestampService timestampService) {
        this.revenuePaymentRepository = revenuePaymentRepository;
        this.expensePaymentRepository = expensePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<IncomeWrapper> getNetIncomes(String year, String startMonth, String endMonth) {
        List<IncomeWrapper> incomeWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            Income income = new Income();
            income.setTimestamp(timestamp);
            income.setTotalRevenue(calculateTotalIncome(timestamp));
            income.setTotalExpense(calculateTotalExpense(timestamp));
            income.setTotalIncome(calculateNetIncome(income.getTotalRevenue(), income.getTotalExpense()));
            incomeWrappers.add(new IncomeWrapper(income));
        }
        return incomeWrappers;
    }

    private long calculateTotalIncome(long timestamp) {
        List<RevenuePayment> revenuePayments = revenuePaymentRepository.findByPaymentTimestamp(timestamp);
        return revenuePayments.stream().mapToLong(RevenuePayment::getPaymentAmount).sum();
    }

    private long calculateTotalExpense(long timestamp) {
        List<ExpensePayment> expensePayments = expensePaymentRepository.findByPaymentTimestampOrderByExpenseType(timestamp);
        return expensePayments.stream().mapToLong(ExpensePayment::getPaymentAmount).sum();
    }

    private long calculateNetIncome(long income, long expense) {
        return income - expense;
    }

}
