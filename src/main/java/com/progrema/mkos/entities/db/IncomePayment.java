package com.progrema.mkos.entities.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
public class IncomePayment {

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

}
