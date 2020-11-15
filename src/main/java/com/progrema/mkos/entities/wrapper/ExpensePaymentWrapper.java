package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.ExpensePayment;
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

    public void addExpenses(ExpensePayment expensePayment) {
        this.expenses.add(expensePayment);
    }

}
