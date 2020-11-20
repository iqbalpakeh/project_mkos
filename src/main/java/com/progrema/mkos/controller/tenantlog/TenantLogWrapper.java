package com.progrema.mkos.controller.tenantlog;

import com.progrema.mkos.entities.TenantLog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantLogWrapper {

    private final TenantLog tenantLog;

    public TenantLogWrapper(TenantLog tenantLog) {
        this.tenantLog = tenantLog;
    }

}
