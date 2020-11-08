package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.IncomePaymentWrapper;
import com.progrema.mkos.repositories.IncomePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomePaymentServiceImpl implements IncomePaymentService {

    private final IncomePaymentRepository incomePaymentRepository;

    public IncomePaymentServiceImpl(IncomePaymentRepository incomePaymentRepository) {
        this.incomePaymentRepository = incomePaymentRepository;
    }

    @Override
    public List<IncomePaymentWrapper> getIncomePayments() {
        List<IncomePaymentWrapper> incomePaymentWrappers = new ArrayList<>();
        incomePaymentRepository.findAll().forEach(incomePayment -> {
            incomePaymentWrappers.add(new IncomePaymentWrapper(incomePayment));
        });
        return incomePaymentWrappers;
    }
}
