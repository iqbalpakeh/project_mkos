package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.Expense;
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
