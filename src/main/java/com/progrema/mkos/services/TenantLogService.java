package com.progrema.mkos.services;

import com.progrema.mkos.controller.tenantlog.wrapper.TenantLogWrapper;

import java.util.List;

public interface TenantLogService {

    List<TenantLogWrapper> getTenantLogs();

}
