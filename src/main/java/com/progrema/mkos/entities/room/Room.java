package com.progrema.mkos.entities.room;

import com.progrema.mkos.entities.tenant.Tenant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private Long roomRate;

    private String roomInformation;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomRate=" + roomRate +
                ", roomInformation='" + roomInformation + '\'' +
                ", tenant='" + (tenant != null ? tenant.getTenantName() : "") + '\'' +
                '}';
    }

}
