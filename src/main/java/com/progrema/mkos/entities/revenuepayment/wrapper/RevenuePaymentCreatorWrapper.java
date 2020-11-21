package com.progrema.mkos.entities.revenuepayment.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevenuePaymentCreatorWrapper {

    private Long paymentTimestamp;

    private Long paymentAmount;

    private String paymentInformation;

    private String roomNumber;

    @Override
    public String toString() {
        return "RevenuePaymentCreatorWrapper{" +
                "paymentTimestamp=" + paymentTimestamp +
                ", paymentAmount=" + paymentAmount +
                ", paymentInformation='" + paymentInformation + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
