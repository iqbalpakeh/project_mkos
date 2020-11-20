package com.progrema.mkos.services;

import com.progrema.mkos.controller.revenuepayment.RevenuePaymentWrapper;
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
    public List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth) {
        List<RevenuePaymentWrapper> revenuePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            RevenuePaymentWrapper revenuePaymentWrapper = new RevenuePaymentWrapper(timestamp);
            revenuePaymentRepository.findByPaymentTimestamp(timestamp).forEach(revenuePaymentWrapper::addRevenuePayment);
            revenuePaymentWrappers.add(revenuePaymentWrapper);
        }
        return revenuePaymentWrappers;
    }
}
