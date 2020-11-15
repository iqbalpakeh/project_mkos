package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.ExpensePaymentWrapper;

import java.util.List;

public interface ExpensePaymentService {

    List<ExpensePaymentWrapper> getExpensePayments();

    List<ExpensePaymentWrapper> getExpensePayments(String year, String startMonth, String endMonth);

}
