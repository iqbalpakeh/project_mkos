package com.progrema.mkos;

import com.progrema.mkos.entities.db.TenantLog;
import com.progrema.mkos.repositories.TenantLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTenantLogTests {

    @Autowired
    private TenantLogRepository tenantLogRepository;

    @BeforeEach
    void init() {
        tenantLogRepository.deleteAll();
    }

    @Test
    void clear() {
        // do nothing
    }

    @Test
    void createTenantLogTest01() {
        {
            TenantLog tenantLog = new TenantLog();
            tenantLog.setCheckin(202001L);
            tenantLog.setCheckout(202002L);
            tenantLog.setTenantName("Iqbal Pakeh");
            tenantLog.setTenantPhone("081808488442");
            tenantLog.setRoomNumber("C");
            tenantLogRepository.save(tenantLog);
        }
        {
            TenantLog tenantLog = tenantLogRepository.findByCheckin(202001L).get(0);
            assertEquals(202001L, tenantLog.getCheckin());
            assertEquals(202002L, tenantLog.getCheckout());
            assertEquals("Iqbal Pakeh", tenantLog.getTenantName());
            assertEquals("081808488442", tenantLog.getTenantPhone());
            assertEquals("C", tenantLog.getRoomNumber());
        }
    }

}
