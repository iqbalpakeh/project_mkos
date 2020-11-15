package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.RevenuePayment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevenuePaymentWrapper {

    private final RevenuePayment revenuePayment;

    public RevenuePaymentWrapper(RevenuePayment revenuePayment) {
        this.revenuePayment = revenuePayment;
    }

}
