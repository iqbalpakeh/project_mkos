package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.IncomePaymentWrapper;
import com.progrema.mkos.repositories.IncomePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomePaymentServiceImpl implements IncomePaymentService {

    private final IncomePaymentRepository incomePaymentRepository;
    private final TimestampService timestampService;

    public IncomePaymentServiceImpl(IncomePaymentRepository incomePaymentRepository,
                                    TimestampService timestampService) {
        this.incomePaymentRepository = incomePaymentRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<IncomePaymentWrapper> getIncomePayments() {
        List<IncomePaymentWrapper> incomePaymentWrappers = new ArrayList<>();
        incomePaymentRepository.findAll().forEach(incomePayment -> {
            incomePaymentWrappers.add(new IncomePaymentWrapper(incomePayment));
        });
        return incomePaymentWrappers;
    }

    @Override
    public List<IncomePaymentWrapper> getIncomePayments(String year, String startMonth, String endMonth) {
        List<IncomePaymentWrapper> incomePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            incomePaymentRepository.findByPaymentTimestamp(timestamp).forEach(incomePayment -> {
                incomePaymentWrappers.add(new IncomePaymentWrapper(incomePayment));
            });
        }
        return incomePaymentWrappers;
    }
}
