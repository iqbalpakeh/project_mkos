package com.progrema.mkos.services;

import com.progrema.mkos.entities.room.Room;
import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.entities.tenant.wrapper.TenantCheckoutWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantCreatorWrapper;
import com.progrema.mkos.entities.tenant.wrapper.TenantWrapper;
import com.progrema.mkos.entities.tenantlog.TenantLog;
import com.progrema.mkos.repositories.RoomRepository;
import com.progrema.mkos.repositories.TenantLogRepository;
import com.progrema.mkos.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantLogRepository tenantLogRepository;
    private final RoomRepository roomRepository;

    public TenantServiceImpl(TenantRepository tenantRepository,
                             TenantLogRepository tenantLogRepository,
                             RoomRepository roomRepository) {
        this.tenantRepository = tenantRepository;
        this.tenantLogRepository = tenantLogRepository;
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

    @Override
    public Tenant checkoutTenant(TenantCheckoutWrapper wrapper) {
        Room room = roomRepository.findByRoomNumber(wrapper.getRoomNumber()).get(0);
        Tenant tenant = room.getTenant();
        tenant.setCheckout(wrapper.getCheckout());

        room.setTenant(null);
        roomRepository.save(room);

        tenantLogRepository.save(new TenantLog(tenant));
        tenantRepository.delete(tenant);
        return tenant;
    }
}
