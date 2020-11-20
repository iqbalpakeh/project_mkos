package com.progrema.mkos.entities.tenantlog;

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
