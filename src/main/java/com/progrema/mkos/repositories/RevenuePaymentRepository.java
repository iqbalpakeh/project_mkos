package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RevenuePaymentRepository extends PagingAndSortingRepository<RevenuePayment, Long> {

    List<RevenuePayment> findByPaymentTimestamp(long timestamp);

}
