package com.progrema.mkos.services;

import com.progrema.mkos.entities.room.Room;
import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.entities.tenant.wrapper.TenantCreatorWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantWrapper;
import com.progrema.mkos.repositories.RoomRepository;
import com.progrema.mkos.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final RoomRepository roomRepository;

    public TenantServiceImpl(TenantRepository tenantRepository,
                             RoomRepository roomRepository) {
        this.tenantRepository = tenantRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<TenantWrapper> getTenants() {
        List<TenantWrapper> tenantWrappers = new ArrayList<>();
        tenantRepository.findAll().forEach(tenant -> {
            tenantWrappers.add(new TenantWrapper(tenant));
        });
        return tenantWrappers;
    }

    @Override
    public Tenant createTenant(TenantCreatorWrapper wrapper) {
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName(wrapper.getTenantName());
            tenant.setTenantPhone(wrapper.getTenantPhone());
            tenant.setCheckin(wrapper.getCheckin());
            tenantRepository.save(tenant);
        }
        {
            Room room = roomRepository.findByRoomNumber(wrapper.getRoomNumber()).get(0);
            Tenant tenant = tenantRepository.findByTenantName(wrapper.getTenantName()).get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
        }
        return tenantRepository.findByTenantName(wrapper.getTenantName()).get(0);
    }
}
