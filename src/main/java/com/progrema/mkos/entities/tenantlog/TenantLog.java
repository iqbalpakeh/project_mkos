package com.progrema.mkos.entities.tenantlog;

import com.progrema.mkos.entities.tenant.Tenant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TenantLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long checkin;

    private Long checkout;

    private String tenantName;

    private String tenantPhone;

    private String roomNumber;

    public TenantLog() {
    }

    public TenantLog(Tenant tenant) {
        checkin = tenant.getCheckin();
        checkout = tenant.getCheckout();
        tenantName = tenant.getTenantName();
        tenantPhone = tenant.getTenantPhone();
        roomNumber = tenant.getRoom().getRoomNumber();
    }

    @Override
    public String toString() {
        return "TenantLog{" +
                "id=" + id +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", tenantName='" + tenantName + '\'' +
                ", tenantPhone='" + tenantPhone + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

}
