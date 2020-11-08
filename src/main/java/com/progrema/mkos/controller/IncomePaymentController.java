package com.progrema.mkos.controller;

import com.progrema.mkos.entities.wrapper.IncomePaymentWrapper;
import com.progrema.mkos.services.IncomePaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomePaymentController {

    private final IncomePaymentService incomePaymentService;

    public IncomePaymentController(IncomePaymentService incomePaymentService) {
        this.incomePaymentService = incomePaymentService;
    }

    @GetMapping("/api/income-payments")
    public List<IncomePaymentWrapper> getIncomePayments() {
        return incomePaymentService.getIncomePayments();
    }
}
