package com.progrema.mkos.services;

import com.progrema.mkos.entities.db.ExpensePayment;
import com.progrema.mkos.entities.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensePaymentServiceImpl implements ExpensePaymentService {

    private final ExpensePaymentRepository expensePaymentRepository;
    private final TimestampService timestampService;

    public ExpensePaymentServiceImpl(ExpensePaymentRepository expensePaymentRepository, TimestampService timestampService) {
        this.expensePaymentRepository = expensePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<ExpensePaymentWrapper> getExpensePayments() {
        List<ExpensePaymentWrapper> expensePaymentWrappers = new ArrayList<>();
        expensePaymentRepository.findAll().forEach(expensePayment -> {
            expensePaymentWrappers.add(new ExpensePaymentWrapper(expensePayment));
        });
        return expensePaymentWrappers;
    }

    @Override
    public List<ExpensePaymentWrapper> getExpensePayments(String year, String startMonth, String endMonth) {
        List<ExpensePaymentWrapper> expensePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = Long.parseLong(year + timestampService.convertMonth(i));
            expensePaymentRepository.findByPaymentTimestamp(timestamp).forEach(expensePayment -> {
                expensePaymentWrappers.add(new ExpensePaymentWrapper(expensePayment));
            });
        }
        return expensePaymentWrappers;
    }
}
