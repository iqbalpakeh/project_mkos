package com.progrema.mkos.services;

import com.progrema.mkos.controller.tenantlog.TenantLogWrapper;

import java.util.List;

public interface TenantLogService {

    List<TenantLogWrapper> getTenantLogs();

}
