package com.progrema.mkos.entities.expensepayment.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensePaymentCreatorWrapper {

    private Long paymentTimestamp;

    private Long paymentAmount;

    private String paymentInformation;

    private String expenseType;

    @Override
    public String toString() {
        return "ExpensePaymentCreatorWrapper{" +
                "paymentTimestamp=" + paymentTimestamp +
                ", paymentAmount=" + paymentAmount +
                ", paymentInformation='" + paymentInformation + '\'' +
                ", expenseType='" + expenseType + '\'' +
                '}';
    }
}
