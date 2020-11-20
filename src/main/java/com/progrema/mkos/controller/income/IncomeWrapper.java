package com.progrema.mkos.controller.income;

import com.progrema.mkos.entities.Income;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeWrapper {

    private final Income income;

    public IncomeWrapper(Income income) {
        this.income = income;
    }
}
