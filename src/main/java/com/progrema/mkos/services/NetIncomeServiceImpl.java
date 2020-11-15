package com.progrema.mkos.services;

import com.progrema.mkos.entities.model.ExpensePayment;
import com.progrema.mkos.entities.model.IncomePayment;
import com.progrema.mkos.entities.model.NetIncome;
import com.progrema.mkos.entities.wrapper.NetIncomeWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import com.progrema.mkos.repositories.IncomePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetIncomeServiceImpl implements NetIncomeService {

    private final IncomePaymentRepository incomePaymentRepository;
    private final ExpensePaymentRepository expensePaymentRepository;
    private final TimestampService timestampService;

    public NetIncomeServiceImpl(IncomePaymentRepository incomePaymentRepository,
                                ExpensePaymentRepository expensePaymentRepository,
                                TimestampService timestampService) {
        this.incomePaymentRepository = incomePaymentRepository;
        this.expensePaymentRepository = expensePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<NetIncomeWrapper> getNetIncomes(String year, String startMonth, String endMonth) {
        List<NetIncomeWrapper> netIncomeWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            NetIncome netIncome  = new NetIncome();
            netIncome.setTimestamp(timestamp);
            netIncome.setTotalIncome(calculateTotalIncome(timestamp));
            netIncome.setTotalExpense(calculateTotalExpense(timestamp));
            netIncome.setNetIncome(calculateNetIncome(netIncome.getTotalIncome(), netIncome.getTotalExpense()));
            netIncomeWrappers.add(new NetIncomeWrapper(netIncome));
        }
        return netIncomeWrappers;
    }

    private long calculateTotalIncome(long timestamp) {
        List<IncomePayment> incomePayments = incomePaymentRepository.findByPaymentTimestamp(timestamp);
        return incomePayments.stream().mapToLong(IncomePayment::getPaymentAmount).sum();
    }

    private long calculateTotalExpense(long timestamp) {
        List<ExpensePayment> expensePayments = expensePaymentRepository.findByPaymentTimestamp(timestamp);
        return expensePayments.stream().mapToLong(ExpensePayment::getPaymentAmount).sum();
    }

    private long calculateNetIncome(long income, long expense) {
        return income - expense;
    }

}
