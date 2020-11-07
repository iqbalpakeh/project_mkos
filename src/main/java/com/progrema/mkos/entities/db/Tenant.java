package com.progrema.mkos.entities.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({ "room" }) // to avoid cycle json creation with room object
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenantName;

    private String tenantPhone;

    @OneToOne(mappedBy = "tenant")
    private Room room;

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", tenantName='" + tenantName + '\'' +
                ", tenantPhone='" + tenantPhone + '\'' +
                ", room=" + (room != null ? room.getRoomNumber() : "") +
                '}';
    }
}
