package com.progrema.mkos.services;

import com.progrema.mkos.controller.expense.ExpenseWrapper;
import com.progrema.mkos.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<ExpenseWrapper> getExpenses() {
        List<ExpenseWrapper> expenseWrappers = new ArrayList<>();
        expenseRepository.findAll().forEach(expense -> {
            expenseWrappers.add(new ExpenseWrapper(expense));
        });
        return expenseWrappers;
    }
}
