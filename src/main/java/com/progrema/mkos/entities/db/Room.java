package com.progrema.mkos.entities.db;

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

}
