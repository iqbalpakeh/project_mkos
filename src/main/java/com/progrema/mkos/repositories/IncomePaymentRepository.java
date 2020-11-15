package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.model.IncomePayment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IncomePaymentRepository extends PagingAndSortingRepository<IncomePayment, Long> {

    List<IncomePayment> findByPaymentTimestamp(long timestamp);

}
