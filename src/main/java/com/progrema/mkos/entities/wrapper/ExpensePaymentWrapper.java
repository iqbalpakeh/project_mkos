package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.db.ExpensePayment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensePaymentWrapper {

    private ExpensePayment expensePayment;

    public ExpensePaymentWrapper(ExpensePayment expensePayment) {
        this.expensePayment = expensePayment;
    }

}