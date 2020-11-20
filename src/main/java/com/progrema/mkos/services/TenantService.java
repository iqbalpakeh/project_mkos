package com.progrema.mkos.services;

import com.progrema.mkos.controller.tenant.TenantWrapper;

import java.util.List;

public interface TenantService {

    List<TenantWrapper> getTenants();

}
