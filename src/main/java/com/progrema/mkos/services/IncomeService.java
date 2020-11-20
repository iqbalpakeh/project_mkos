package com.progrema.mkos.services;

import com.progrema.mkos.entities.revenuepayment.wrapper.IncomeWrapper;

import java.util.List;

public interface IncomeService {

    List<IncomeWrapper> getNetIncomes(String year, String startMonth, String endMonth);

}
