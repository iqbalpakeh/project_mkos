package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.TenantLog;
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
