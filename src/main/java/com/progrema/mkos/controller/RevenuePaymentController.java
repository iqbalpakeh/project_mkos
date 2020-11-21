package com.progrema.mkos.controller;

import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentCreatorWrapper;
import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentCreatorWrapper;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentWrapper;
import com.progrema.mkos.services.RevenuePaymentService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/revenue-payments-create")
    public RevenuePayment createRevenuePayment(@RequestBody RevenuePaymentCreatorWrapper wrapper) {
        return revenuePaymentService.createRevenuePayment(wrapper);
    }
}
