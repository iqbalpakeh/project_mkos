package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.RevenuePaymentWrapper;

import java.util.List;

public interface RevenuePaymentService {

    List<RevenuePaymentWrapper> getRevenuePayments();

    List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth);

}
