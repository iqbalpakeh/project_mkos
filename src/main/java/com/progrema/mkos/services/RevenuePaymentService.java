package com.progrema.mkos.services;

import com.progrema.mkos.controller.revenuepayment.RevenuePaymentWrapper;

import java.util.List;

public interface RevenuePaymentService {

    List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth);

}
