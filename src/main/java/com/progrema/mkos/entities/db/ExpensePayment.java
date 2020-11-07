package com.progrema.mkos.entities.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ExpensePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentTimestamp;

    private Long paymentAmount;

    private String paymentInformation;

    private String expenseType;

    private String expenseInformation;

}
