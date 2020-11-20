package com.progrema.mkos.services;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentCreatorWrapper;
import com.progrema.mkos.entities.expensepayment.wrapper.ExpensePaymentWrapper;

import java.util.List;

public interface ExpensePaymentService {

    List<ExpensePaymentWrapper> getExpensePayments(String year, String startMonth, String endMonth);

    ExpensePayment createExpensePayment(ExpensePaymentCreatorWrapper expensePaymentCreatorWrapper);

}
