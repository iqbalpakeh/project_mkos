package com.progrema.mkos.services;

import com.progrema.mkos.controller.expensepayment.ExpensePaymentWrapper;

import java.util.List;

public interface ExpensePaymentService {

    List<ExpensePaymentWrapper> getExpensePayments(String year, String startMonth, String endMonth);

}
