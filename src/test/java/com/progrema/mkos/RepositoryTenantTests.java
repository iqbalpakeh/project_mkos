package com.progrema.mkos;

import com.progrema.mkos.entities.model.Tenant;
import com.progrema.mkos.repositories.RoomRepository;
import com.progrema.mkos.repositories.TenantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTenantTests {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private RoomRepository roomRepository;

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
    void createTenantTest01() {
        {
            Tenant tenant1 = new Tenant();
            tenant1.setTenantName("M Lutfi");
            tenant1.setTenantPhone("081811112222");
            tenantRepository.save(tenant1);

            Tenant tenant2 = new Tenant();
            tenant2.setTenantName("Ansor Azari");
            tenant2.setTenantPhone("0818888999");
            tenantRepository.save(tenant2);
        }
        {
            Tenant tenant1 = tenantRepository.findByTenantName("M Lutfi").get(0);
            assertEquals("M Lutfi", tenant1.getTenantName());
            assertEquals("081811112222", tenant1.getTenantPhone());

            Tenant tenant2 = tenantRepository.findByTenantName("Ansor Azari").get(0);
            assertEquals("Ansor Azari", tenant2.getTenantName());
            assertEquals("0818888999", tenant2.getTenantPhone());
        }
    }

}
