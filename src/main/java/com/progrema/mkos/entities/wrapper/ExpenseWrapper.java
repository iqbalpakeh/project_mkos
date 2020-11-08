package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.db.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseWrapper {

    private Expense expense;

    public ExpenseWrapper(Expense expense) {
        this.expense = expense;
    }

}
