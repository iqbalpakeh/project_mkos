package com.progrema.mkos.services;

import com.progrema.mkos.entities.tenant.wrapper.TenantWrapper;
import com.progrema.mkos.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<TenantWrapper> getTenants() {
        List<TenantWrapper> tenantWrappers = new ArrayList<>();
        tenantRepository.findAll().forEach(tenant -> {
            tenantWrappers.add(new TenantWrapper(tenant));
        });
        return tenantWrappers;
    }
}
