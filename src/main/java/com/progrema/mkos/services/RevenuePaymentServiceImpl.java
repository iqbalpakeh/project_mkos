package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.RevenuePaymentWrapper;
import com.progrema.mkos.repositories.RevenuePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevenuePaymentServiceImpl implements RevenuePaymentService {

    private final RevenuePaymentRepository revenuePaymentRepository;
    private final TimestampService timestampService;

    public RevenuePaymentServiceImpl(RevenuePaymentRepository revenuePaymentRepository,
                                     TimestampService timestampService) {
        this.revenuePaymentRepository = revenuePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<RevenuePaymentWrapper> getRevenuePayments() {
        List<RevenuePaymentWrapper> revenuePaymentWrappers = new ArrayList<>();
        revenuePaymentRepository.findAll().forEach(incomePayment -> {
            revenuePaymentWrappers.add(new RevenuePaymentWrapper(incomePayment));
        });
        return revenuePaymentWrappers;
    }

    @Override
    public List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth) {
        List<RevenuePaymentWrapper> revenuePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            revenuePaymentRepository.findByPaymentTimestamp(timestamp).forEach(incomePayment -> {
                revenuePaymentWrappers.add(new RevenuePaymentWrapper(incomePayment));
            });
        }
        return revenuePaymentWrappers;
    }
}
