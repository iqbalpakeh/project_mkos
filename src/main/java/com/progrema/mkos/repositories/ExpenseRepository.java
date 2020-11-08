package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.Expense;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {

    List<Expense> findByExpenseType(String expenseType);

}
