package com.progrema.mkos;

import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import com.progrema.mkos.repositories.RevenuePaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryRevenuePaymentTests {

    @Autowired
    private RevenuePaymentRepository revenuePaymentRepository;

    @BeforeEach
    void init() {
        revenuePaymentRepository.deleteAll();
    }

    @Test
    void clear() {
        // do nothing
    }

    @Test
    void createIncomePaymentTest01() {
        {
            RevenuePayment revenuePayment = new RevenuePayment();
            revenuePayment.setPaymentTimestamp(202001L);
            revenuePayment.setPaymentAmount(300000L);
            revenuePayment.setPaymentInformation("Income payment from Room B");
            revenuePayment.setRoomNumber("B");
            revenuePayment.setRoomRate(300000L);
            revenuePayment.setRoomInformation("Room B is on the second floor");
            revenuePayment.setTenantName("Mohammad Luthfi");
            revenuePayment.setTenantPhone("081811112222");
            revenuePaymentRepository.save(revenuePayment);
        }
        {
            RevenuePayment revenuePayment = revenuePaymentRepository.findByPaymentTimestamp(202001L).get(0);
            assertEquals(202001L, revenuePayment.getPaymentTimestamp());
            assertEquals(300000L, revenuePayment.getPaymentAmount());
            assertEquals("Income payment from Room B", revenuePayment.getPaymentInformation());
            assertEquals("B", revenuePayment.getRoomNumber());
            assertEquals(300000L, revenuePayment.getRoomRate());
            assertEquals("Room B is on the second floor", revenuePayment.getRoomInformation());
            assertEquals("Mohammad Luthfi", revenuePayment.getTenantName());
            assertEquals("081811112222", revenuePayment.getTenantPhone());
        }
    }

    @Test
    void createIncomePaymentTest02() {
        {
            RevenuePayment revenuePayment1 = new RevenuePayment();
            revenuePayment1.setPaymentTimestamp(202001L);
            revenuePayment1.setPaymentAmount(300000L);
            revenuePayment1.setPaymentInformation("Income payment from Room B");
            revenuePayment1.setRoomNumber("B");
            revenuePayment1.setRoomRate(300000L);
            revenuePayment1.setRoomInformation("Room B is on the second floor");
            revenuePayment1.setTenantName("Mohammad Luthfi");
            revenuePayment1.setTenantPhone("081811112222");
            revenuePaymentRepository.save(revenuePayment1);

            RevenuePayment revenuePayment2 = new RevenuePayment();
            revenuePayment2.setPaymentTimestamp(202001L);
            revenuePayment2.setPaymentAmount(300000L);
            revenuePayment2.setPaymentInformation("Income payment from Room B");
            revenuePayment2.setRoomNumber("B");
            revenuePayment2.setRoomRate(300000L);
            revenuePayment2.setRoomInformation("Room B is on the second floor");
            revenuePayment2.setTenantName("Mohammad Luthfi");
            revenuePayment2.setTenantPhone("081811112222");
            revenuePaymentRepository.save(revenuePayment2);

            RevenuePayment revenuePayment3 = new RevenuePayment();
            revenuePayment3.setPaymentTimestamp(202002L);
            revenuePayment3.setPaymentAmount(300000L);
            revenuePayment3.setPaymentInformation("Income payment from Room B");
            revenuePayment3.setRoomNumber("B");
            revenuePayment3.setRoomRate(300000L);
            revenuePayment3.setRoomInformation("Room B is on the second floor");
            revenuePayment3.setTenantName("Mohammad Luthfi");
            revenuePayment3.setTenantPhone("081811112222");
            revenuePaymentRepository.save(revenuePayment3);
        }
        {
            List<RevenuePayment> revenuePayments2020Jan = revenuePaymentRepository.findByPaymentTimestamp(202001L);
            assertEquals(2, revenuePayments2020Jan.size());

            List<RevenuePayment> revenuePayments2020Feb = revenuePaymentRepository.findByPaymentTimestamp(202002L);
            assertEquals(1, revenuePayments2020Feb.size());
        }
    }

}
