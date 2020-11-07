package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.ExpensePayment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpensePaymentRepository extends PagingAndSortingRepository<ExpensePayment, Long> {
}
