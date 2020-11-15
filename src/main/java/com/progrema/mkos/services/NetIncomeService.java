package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.NetIncomeWrapper;

import java.util.List;

public interface NetIncomeService {

    List<NetIncomeWrapper> getNetIncomes(String year, String startMonth, String endMonth);

}
