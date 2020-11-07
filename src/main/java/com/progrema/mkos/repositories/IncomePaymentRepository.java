package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.IncomePayment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IncomePaymentRepository extends PagingAndSortingRepository<IncomePayment, Long> {
}
