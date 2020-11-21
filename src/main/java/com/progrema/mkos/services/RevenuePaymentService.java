package com.progrema.mkos.services;

import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentCreatorWrapper;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentWrapper;

import java.util.List;

public interface RevenuePaymentService {

    List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth);

    RevenuePayment createRevenuePayment(RevenuePaymentCreatorWrapper wrapper);

}
