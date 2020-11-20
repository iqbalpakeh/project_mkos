package com.progrema.mkos.services;

import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensePaymentServiceImpl implements ExpensePaymentService {

    private final ExpensePaymentRepository expensePaymentRepository;
    private final TimestampService timestampService;

    public ExpensePaymentServiceImpl(ExpensePaymentRepository expensePaymentRepository,
                                     TimestampService timestampService) {
        this.expensePaymentRepository = expensePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<ExpensePaymentWrapper> getExpensePayments(String year, String startMonth, String endMonth) {
        List<ExpensePaymentWrapper> expensePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            ExpensePaymentWrapper expensePaymentWrapper = new ExpensePaymentWrapper(timestamp);
            expensePaymentRepository.findByPaymentTimestampOrderByExpenseType(timestamp).forEach(expensePaymentWrapper::addExpensePayment);
            expensePaymentWrappers.add(expensePaymentWrapper);
        }
        return expensePaymentWrappers;
    }
}
