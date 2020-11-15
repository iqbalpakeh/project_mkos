package com.progrema.mkos.entities.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class RevenuePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentTimestamp;

    private Long paymentAmount;

    private String paymentInformation;

    // -----------------------------
    // Room property's log
    // -----------------------------

    private String roomNumber;

    private Long roomRate;

    private String roomInformation;

    // -----------------------------
    // Tenant property's log
    // -----------------------------

    private String tenantName;

    private String tenantPhone;

    @Override
    public String toString() {
        return "RevenuePayment{" +
                "id=" + id +
                ", paymentTimestamp=" + paymentTimestamp +
                ", paymentAmount=" + paymentAmount +
                ", paymentInformation='" + paymentInformation + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomRate=" + roomRate +
                ", roomInformation='" + roomInformation + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", tenantPhone='" + tenantPhone + '\'' +
                '}';
    }
}
