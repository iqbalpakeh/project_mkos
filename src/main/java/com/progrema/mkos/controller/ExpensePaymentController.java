package com.progrema.mkos.controller;

import com.progrema.mkos.entities.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.services.ExpensePaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensePaymentController {

    private final ExpensePaymentService expensePaymentService;

    public ExpensePaymentController(ExpensePaymentService expensePaymentService) {
        this.expensePaymentService = expensePaymentService;
    }

    @GetMapping("/api/expense-payments")
    public List<ExpensePaymentWrapper> getExpensePayments() {
        return expensePaymentService.getExpensePayments();
    }

    @GetMapping("/api/expense-payments-range")
    public List<ExpensePaymentWrapper> getExpensePayments(@RequestParam String year,
                                                          @RequestParam String startMonth,
                                                          @RequestParam String endMonth) {
        return expensePaymentService.getExpensePayments(year, startMonth, endMonth);
    }

}
