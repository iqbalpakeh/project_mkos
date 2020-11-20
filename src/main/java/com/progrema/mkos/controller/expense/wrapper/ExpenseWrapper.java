package com.progrema.mkos.controller.expense.wrapper;

import com.progrema.mkos.entities.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseWrapper {

    private final Expense expense;

    public ExpenseWrapper(Expense expense) {
        this.expense = expense;
    }

}
