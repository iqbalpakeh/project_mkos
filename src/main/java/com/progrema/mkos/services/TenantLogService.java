package com.progrema.mkos.services;

import com.progrema.mkos.entities.tenantlog.wrapper.TenantLogWrapper;

import java.util.List;

public interface TenantLogService {

    List<TenantLogWrapper> getTenantLogs();

}
