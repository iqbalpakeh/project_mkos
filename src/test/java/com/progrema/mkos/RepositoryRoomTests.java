package com.progrema.mkos;
import com.progrema.mkos.entities.room.Room;
import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.repositories.RoomRepository;
import com.progrema.mkos.repositories.TenantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryRoomTests {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @BeforeEach
    void init() {
        roomRepository.deleteAll();
        tenantRepository.deleteAll();
    }

    @Test
    void clear() {
        // do nothing
    }

    @Test
    void testCreateRoomTest01() {
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("M Lutfi");
            tenant.setTenantPhone("081811112222");
            tenant.setCheckin(202001L);
            tenant.setCheckout(202002L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = tenantRepository.findByTenantName("M Lutfi").get(0);
            Room room = new Room();
            room.setRoomNumber("B");
            room.setRoomRate(550000L);
            room.setRoomInformation("Located at 2nd floor");
            room.setTenant(tenant);
            roomRepository.save(room);
        }
        {
            Room room = roomRepository.findByRoomNumber("B").get(0);
            assertEquals("B", room.getRoomNumber());
            assertEquals(550000L, room.getRoomRate());
            assertEquals("Located at 2nd floor", room.getRoomInformation());

            Tenant tenant = room.getTenant();
            assertEquals("M Lutfi", tenant.getTenantName());
            assertEquals("081811112222", tenant.getTenantPhone());
            assertEquals(202001L, tenant.getCheckin());
            assertEquals(202002L, tenant.getCheckout());
        }
    }

    @Test
    void testCreateRoomTest02() {
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("M Lutfi");
            tenant.setTenantPhone("081811112222");
            tenant.setCheckin(202001L);
            tenant.setCheckout(202002L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = tenantRepository.findByTenantName("M Lutfi").get(0);
            Room room = new Room();
            room.setRoomNumber("B");
            room.setRoomRate(550000L);
            room.setRoomInformation("Located at 2nd floor");
            room.setTenant(tenant);
            roomRepository.save(room);
        }
        {
            Tenant tenant = tenantRepository.findByTenantName("M Lutfi").get(0);
            assertEquals("M Lutfi", tenant.getTenantName());
            assertEquals("081811112222", tenant.getTenantPhone());

            Room room = tenant.getRoom();
            assertEquals("B", room.getRoomNumber());
            assertEquals(550000L, room.getRoomRate());
            assertEquals("Located at 2nd floor", room.getRoomInformation());
            assertEquals(202001L, tenant.getCheckin());
            assertEquals(202002L, tenant.getCheckout());
        }
    }

    @Test
    void testCreateRoomTest03() {
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("M Lutfi");
            tenant.setTenantPhone("081811112222");
            tenant.setCheckin(202001L);
            tenant.setCheckout(202002L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = tenantRepository.findByTenantName("M Lutfi").get(0);
            Room room = new Room();
            room.setRoomNumber("B");
            room.setRoomRate(550000L);
            room.setRoomInformation("Located at 2nd floor");
            room.setTenant(tenant);
            roomRepository.save(room);
        }
        {
            roomRepository.findAll().forEach(System.out::println);
        }
    }

}
