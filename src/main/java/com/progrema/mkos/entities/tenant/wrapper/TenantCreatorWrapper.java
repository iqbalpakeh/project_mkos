package com.progrema.mkos.entities.tenant.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantCreatorWrapper {

    private String tenantName;

    private String tenantPhone;

    private Long checkin;

    private String roomNumber;

    @Override
    public String toString() {
        return "TenantCreatorWrapper{" +
                "tenantName='" + tenantName + '\'' +
                ", tenantPhone='" + tenantPhone + '\'' +
                ", checkin=" + checkin +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
