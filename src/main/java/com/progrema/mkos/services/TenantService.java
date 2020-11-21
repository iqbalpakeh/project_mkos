package com.progrema.mkos.services;

import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.entities.tenant.wrapper.TenantCreatorWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantWrapper;

import java.util.List;

public interface TenantService {

    List<TenantWrapper> getTenants();

    Tenant createTenant(TenantCreatorWrapper wrapper);

}
