package com.progrema.mkos.controller.expensepayment;

import com.progrema.mkos.entities.ExpensePayment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ExpensePaymentWrapper {

    private final long timestamp;
    private final List<ExpensePayment> expenses;

    public ExpensePaymentWrapper(long timestamp) {
        this.timestamp = timestamp;
        this.expenses = new ArrayList<>();
    }

    public void addExpensePayment(ExpensePayment expensePayment) {
        this.expenses.add(expensePayment);
    }
}
