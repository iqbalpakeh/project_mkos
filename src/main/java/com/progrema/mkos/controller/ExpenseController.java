package com.progrema.mkos.controller;

import com.progrema.mkos.entities.expense.wrapper.ExpenseWrapper;
import com.progrema.mkos.services.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/api/expenses")
    public List<ExpenseWrapper> getExpenses() {
        return expenseService.getExpenses();
    }

}
