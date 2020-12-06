package com.progrema.mkos.controller;

import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.entities.tenant.wrapper.TenantCheckoutWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantCreatorWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantWrapper;
import com.progrema.mkos.services.TenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {

    private final Logger logger = LoggerFactory.getLogger(TenantController.class);

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/api/tenants")
    public List<TenantWrapper> getTenants() {
        logger.info("getTenants()");
        return tenantService.getTenants();
    }

    @PostMapping("/api/tenants-create")
    public Tenant createTenant(@RequestBody TenantCreatorWrapper wrapper) {
        logger.info("createTenant(wrapper = {})", wrapper);
        return tenantService.createTenant(wrapper);
    }

    @PostMapping("/api/tenants-checkout")
    public Tenant checkoutTenant(@RequestBody TenantCheckoutWrapper wrapper) {
        logger.info("checkoutTenant(wrapper = {})", wrapper);
        return tenantService.checkoutTenant(wrapper);
    }
}
