package com.progrema.mkos.entities.revenuepayment.wrapper;

import com.progrema.mkos.entities.income.Income;
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
