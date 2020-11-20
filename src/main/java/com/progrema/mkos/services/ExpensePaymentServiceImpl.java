package com.progrema.mkos.services;

import com.progrema.mkos.entities.expense.Expense;
import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentCreatorWrapper;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import com.progrema.mkos.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensePaymentServiceImpl implements ExpensePaymentService {

    private final ExpensePaymentRepository expensePaymentRepository;
    private final ExpenseRepository expenseRepository;
    private final TimestampService timestampService;

    public ExpensePaymentServiceImpl(ExpensePaymentRepository expensePaymentRepository,
                                     ExpenseRepository expenseRepository,
                                     TimestampService timestampService) {
        this.expensePaymentRepository = expensePaymentRepository;
        this.expenseRepository = expenseRepository;
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

    @Override
    public ExpensePayment createExpensePayment(ExpensePaymentCreatorWrapper expensePaymentCreatorWrapper) {
        Expense expense = expenseRepository.findByExpenseType(expensePaymentCreatorWrapper.getExpenseType()).get(0);
        ExpensePayment expensePayment = new ExpensePayment();
        expensePayment.setPaymentTimestamp(expensePaymentCreatorWrapper.getPaymentTimestamp());
        expensePayment.setPaymentAmount(expensePaymentCreatorWrapper.getPaymentAmount());
        expensePayment.setPaymentInformation(expensePaymentCreatorWrapper.getPaymentInformation());
        expensePayment.setExpenseType(expense.getExpenseType());
        expensePayment.setExpenseInformation(expense.getExpenseInformation());
        return expensePayment;
    }
}
