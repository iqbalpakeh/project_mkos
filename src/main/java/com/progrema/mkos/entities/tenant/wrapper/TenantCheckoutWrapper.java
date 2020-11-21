package com.progrema.mkos.entities.tenant.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantCheckoutWrapper {

    private Long checkout;

    private String roomNumber;

    @Override
    public String toString() {
        return "TenantCheckoutWrapper{" +
                "checkout=" + checkout +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
