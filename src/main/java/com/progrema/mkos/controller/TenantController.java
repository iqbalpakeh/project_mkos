package com.progrema.mkos.controller;

import com.progrema.mkos.entities.wrapper.TenantWrapper;
import com.progrema.mkos.services.TenantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/api/tenants")
    public List<TenantWrapper> getTenants() {
        return tenantService.getTenants();
    }
}