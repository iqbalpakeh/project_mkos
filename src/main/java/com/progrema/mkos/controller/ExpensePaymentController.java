package com.progrema.mkos.controller;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentCreatorWrapper;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.services.ExpensePaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensePaymentController {

    private final ExpensePaymentService expensePaymentService;

    public ExpensePaymentController(ExpensePaymentService expensePaymentService) {
        this.expensePaymentService = expensePaymentService;
    }

    @GetMapping("/api/expense-payments-range")
    public List<ExpensePaymentWrapper> getExpensePayments(@RequestParam String year,
                                                          @RequestParam String startMonth,
                                                          @RequestParam String endMonth) {
        return expensePaymentService.getExpensePayments(year, startMonth, endMonth);
    }

    @PostMapping("/api/expense-payments-create")
    public ExpensePayment createRevenuePayment(@RequestBody ExpensePaymentCreatorWrapper wrapper) {
        return expensePaymentService.createExpensePayment(wrapper);
    }
}
