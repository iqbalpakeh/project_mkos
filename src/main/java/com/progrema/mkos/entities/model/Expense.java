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
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expenseType;

    private String expenseInformation;

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseType='" + expenseType + '\'' +
                ", expenseInformation='" + expenseInformation + '\'' +
                '}';
    }

}

