package com.progrema.mkos;

import com.progrema.mkos.entities.db.IncomePayment;
import com.progrema.mkos.repositories.IncomePaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryIncomePaymentTests {

    @Autowired
    private IncomePaymentRepository incomePaymentRepository;

    @BeforeEach
    void init() {
        incomePaymentRepository.deleteAll();
    }

    @Test
    void clear() {
        // do nothing
    }

    @Test
    void createIncomePaymentTest01() {
        {
            IncomePayment incomePayment = new IncomePayment();
            incomePayment.setPaymentTimestamp(202001L);
            incomePayment.setPaymentAmount(300000L);
            incomePayment.setPaymentInformation("Income payment from Room B");
            incomePayment.setRoomNumber("B");
            incomePayment.setRoomRate(300000L);
            incomePayment.setRoomInformation("Room B is on the second floor");
            incomePayment.setTenantName("Mohammad Luthfi");
            incomePayment.setTenantPhone("081811112222");
            incomePaymentRepository.save(incomePayment);
        }
        {
            IncomePayment incomePayment = incomePaymentRepository.findByPaymentTimestamp(202001L).get(0);
            assertEquals(202001L, incomePayment.getPaymentTimestamp());
            assertEquals(300000L, incomePayment.getPaymentAmount());
            assertEquals("Income payment from Room B", incomePayment.getPaymentInformation());
            assertEquals("B", incomePayment.getRoomNumber());
            assertEquals(300000L, incomePayment.getRoomRate());
            assertEquals("Room B is on the second floor", incomePayment.getRoomInformation());
            assertEquals("Mohammad Luthfi", incomePayment.getTenantName());
            assertEquals("081811112222", incomePayment.getTenantPhone());
        }
    }

    @Test
    void createIncomePaymentTest02() {
        {
            IncomePayment incomePayment1 = new IncomePayment();
            incomePayment1.setPaymentTimestamp(202001L);
            incomePayment1.setPaymentAmount(300000L);
            incomePayment1.setPaymentInformation("Income payment from Room B");
            incomePayment1.setRoomNumber("B");
            incomePayment1.setRoomRate(300000L);
            incomePayment1.setRoomInformation("Room B is on the second floor");
            incomePayment1.setTenantName("Mohammad Luthfi");
            incomePayment1.setTenantPhone("081811112222");
            incomePaymentRepository.save(incomePayment1);

            IncomePayment incomePayment2 = new IncomePayment();
            incomePayment2.setPaymentTimestamp(202001L);
            incomePayment2.setPaymentAmount(300000L);
            incomePayment2.setPaymentInformation("Income payment from Room B");
            incomePayment2.setRoomNumber("B");
            incomePayment2.setRoomRate(300000L);
            incomePayment2.setRoomInformation("Room B is on the second floor");
            incomePayment2.setTenantName("Mohammad Luthfi");
            incomePayment2.setTenantPhone("081811112222");
            incomePaymentRepository.save(incomePayment2);

            IncomePayment incomePayment3 = new IncomePayment();
            incomePayment3.setPaymentTimestamp(202002L);
            incomePayment3.setPaymentAmount(300000L);
            incomePayment3.setPaymentInformation("Income payment from Room B");
            incomePayment3.setRoomNumber("B");
            incomePayment3.setRoomRate(300000L);
            incomePayment3.setRoomInformation("Room B is on the second floor");
            incomePayment3.setTenantName("Mohammad Luthfi");
            incomePayment3.setTenantPhone("081811112222");
            incomePaymentRepository.save(incomePayment3);
        }
        {
            List<IncomePayment> incomePayments2020Jan = incomePaymentRepository.findByPaymentTimestamp(202001L);
            assertEquals(2, incomePayments2020Jan.size());

            List<IncomePayment> incomePayments2020Feb = incomePaymentRepository.findByPaymentTimestamp(202002L);
            assertEquals(1, incomePayments2020Feb.size());
        }
    }

}
