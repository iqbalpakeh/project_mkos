package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.ExpenseWrapper;

import java.util.List;

public interface ExpenseService {

    List<ExpenseWrapper> getExpenses();

}
