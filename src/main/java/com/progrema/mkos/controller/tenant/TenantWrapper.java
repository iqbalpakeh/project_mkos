package com.progrema.mkos.controller.tenant;

import com.progrema.mkos.entities.Tenant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantWrapper {

    private final Tenant tenant;
    private final String room;

    public TenantWrapper(Tenant tenant) {
        this.tenant = tenant;
        this.room = tenant.getRoom() != null ? tenant.getRoom().getRoomNumber() : "";
    }

}
