package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.Income;
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
