package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.IncomePaymentWrapper;

import java.util.List;

public interface IncomePaymentService {

    List<IncomePaymentWrapper> getIncomePayments();

}
