package com.progrema.mkos;

import com.progrema.mkos.entities.tenantlog.TenantLog;
import com.progrema.mkos.repositories.TenantLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void createTenantLogTest02() {
        {
            TenantLog tenantLog1 = new TenantLog();
            tenantLog1.setCheckin(202001L);
            tenantLog1.setCheckout(202002L);
            tenantLog1.setTenantName("Iqbal Pakeh");
            tenantLog1.setTenantPhone("081808488442");
            tenantLog1.setRoomNumber("C");
            tenantLogRepository.save(tenantLog1);

            TenantLog tenantLog2 = new TenantLog();
            tenantLog2.setCheckin(202001L);
            tenantLog2.setCheckout(202002L);
            tenantLog2.setTenantName("Iqbal Pakeh");
            tenantLog2.setTenantPhone("081808488442");
            tenantLog2.setRoomNumber("C");
            tenantLogRepository.save(tenantLog2);

            TenantLog tenantLog3 = new TenantLog();
            tenantLog3.setCheckin(202002L);
            tenantLog3.setCheckout(202002L);
            tenantLog3.setTenantName("Iqbal Pakeh");
            tenantLog3.setTenantPhone("081808488442");
            tenantLog3.setRoomNumber("C");
            tenantLogRepository.save(tenantLog3);
        }
        {
            List<TenantLog> tenantLogs202001 = tenantLogRepository.findByCheckin(202001L);
            assertEquals(2, tenantLogs202001.size());

            List<TenantLog> tenantLogs202002 = tenantLogRepository.findByCheckin(202002L);
            assertEquals(1, tenantLogs202002.size());
        }
    }

}
