package com.progrema.mkos.entities.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetIncome {

    private long netIncome;
    private long totalIncome;
    private long totalExpense;

    @Override
    public String toString() {
        return "NetIncome{" +
                "netIncome=" + netIncome +
                ", totalIncome=" + totalIncome +
                ", totalExpense=" + totalExpense +
                '}';
    }
}
