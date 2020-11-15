package com.progrema.mkos.controller;

import com.progrema.mkos.entities.wrapper.RevenuePaymentWrapper;
import com.progrema.mkos.services.RevenuePaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevenuePaymentController {

    private final RevenuePaymentService revenuePaymentService;

    public RevenuePaymentController(RevenuePaymentService revenuePaymentService) {
        this.revenuePaymentService = revenuePaymentService;
    }

    @GetMapping("/api/revenue-payments-range")
    public List<RevenuePaymentWrapper> getIncomePayments(@RequestParam String year,
                                                         @RequestParam String startMonth,
                                                         @RequestParam String endMonth) {
        return revenuePaymentService.getRevenuePayments(year, startMonth, endMonth);
    }
}
