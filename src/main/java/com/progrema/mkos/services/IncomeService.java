package com.progrema.mkos.services;

import com.progrema.mkos.controller.income.wrapper.IncomeWrapper;

import java.util.List;

public interface IncomeService {

    List<IncomeWrapper> getNetIncomes(String year, String startMonth, String endMonth);

}
