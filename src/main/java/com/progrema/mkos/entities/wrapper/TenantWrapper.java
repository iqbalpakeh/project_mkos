package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.db.Tenant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantWrapper {

    private final Tenant tenant;

    public TenantWrapper(Tenant tenant) {
        this.tenant = tenant;
    }

}
