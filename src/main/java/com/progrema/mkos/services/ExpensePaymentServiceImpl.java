package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensePaymentServiceImpl implements ExpensePaymentService {

    private final ExpensePaymentRepository expensePaymentRepository;

    public ExpensePaymentServiceImpl(ExpensePaymentRepository expensePaymentRepository) {
        this.expensePaymentRepository = expensePaymentRepository;
    }

    @Override
    public List<ExpensePaymentWrapper> getExpensePayments() {
        List<ExpensePaymentWrapper> expensePaymentWrappers = new ArrayList<>();
        expensePaymentRepository.findAll().forEach(expensePayment -> {
            expensePaymentWrappers.add(new ExpensePaymentWrapper(expensePayment));
        });
        return expensePaymentWrappers;
    }

}
