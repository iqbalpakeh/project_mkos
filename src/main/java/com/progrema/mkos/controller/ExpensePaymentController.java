package com.progrema.mkos.controller;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentCreatorWrapper;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.services.ExpensePaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensePaymentController {

    private final Logger logger = LoggerFactory.getLogger(ExpensePaymentController.class);

    private final ExpensePaymentService expensePaymentService;

    public ExpensePaymentController(ExpensePaymentService expensePaymentService) {
        this.expensePaymentService = expensePaymentService;
    }

    @GetMapping("/api/expense-payments-range")
    public List<ExpensePaymentWrapper> getExpensePayments(@RequestParam String year,
                                                          @RequestParam String startMonth,
                                                          @RequestParam String endMonth) {
        logger.info("getExpensePayments(year = {}, startMonth = {}, endMonth = {})", year, startMonth, endMonth);
        return expensePaymentService.getExpensePayments(year, startMonth, endMonth);
    }

    @PostMapping("/api/expense-payments-create")
    public ExpensePayment createRevenuePayment(@RequestBody ExpensePaymentCreatorWrapper wrapper) {
        logger.info("createExpensePayment(wrapper = {})", wrapper);
        return expensePaymentService.createExpensePayment(wrapper);
    }
}
