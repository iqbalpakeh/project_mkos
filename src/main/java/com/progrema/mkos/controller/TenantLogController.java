package com.progrema.mkos.controller;

import com.progrema.mkos.entities.tenantlog.wrapper.TenantLogWrapper;
import com.progrema.mkos.services.TenantLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantLogController {

    private final Logger logger = LoggerFactory.getLogger(TenantLogController.class);

    private final TenantLogService tenantLogService;

    public TenantLogController(TenantLogService tenantLogService) {
        this.tenantLogService = tenantLogService;
    }

    @GetMapping("/api/tenant-logs")
    public List<TenantLogWrapper> getTenantLogs() {
        logger.info("getTenantLogs()");
        return tenantLogService.getTenantLogs();
    }

}
