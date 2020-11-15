package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.IncomePayment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomePaymentWrapper {

    private final IncomePayment incomePayment;

    public IncomePaymentWrapper(IncomePayment incomePayment) {
        this.incomePayment = incomePayment;
    }

}
