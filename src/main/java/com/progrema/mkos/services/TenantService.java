package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.TenantWrapper;

import java.util.List;

public interface TenantService {

    List<TenantWrapper> getTenants();

}
