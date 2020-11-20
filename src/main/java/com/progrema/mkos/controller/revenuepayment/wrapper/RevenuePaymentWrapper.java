package com.progrema.mkos.controller.revenuepayment.wrapper;

import com.progrema.mkos.entities.RevenuePayment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RevenuePaymentWrapper {

    private final long timestamp;
    private final List<RevenuePayment> revenuePayments;

    public RevenuePaymentWrapper(long timestamp) {
        this.timestamp = timestamp;
        this.revenuePayments = new ArrayList<>();
    }

    public void addRevenuePayment(RevenuePayment revenuePayment) {
        this.revenuePayments.add(revenuePayment);
    }
}
