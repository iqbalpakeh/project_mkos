package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExpensePaymentRepository extends PagingAndSortingRepository<ExpensePayment, Long> {

    List<ExpensePayment> findByPaymentTimestampOrderByExpenseType(long timestamp);

}
