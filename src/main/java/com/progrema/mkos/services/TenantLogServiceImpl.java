package com.progrema.mkos.services;

import com.progrema.mkos.controller.tenantlog.wrapper.TenantLogWrapper;
import com.progrema.mkos.repositories.TenantLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantLogServiceImpl implements TenantLogService {

    private final TenantLogRepository tenantLogRepository;

    public TenantLogServiceImpl(TenantLogRepository tenantLogRepository) {
        this.tenantLogRepository = tenantLogRepository;
    }

    @Override
    public List<TenantLogWrapper> getTenantLogs() {
        List<TenantLogWrapper> tenantLogs = new ArrayList<>();
        tenantLogRepository.findAll().forEach(tenantLog -> {
            tenantLogs.add(new TenantLogWrapper(tenantLog));
        });
        return tenantLogs;
    }

}
