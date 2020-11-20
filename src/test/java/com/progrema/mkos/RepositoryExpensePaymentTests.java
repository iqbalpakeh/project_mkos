package com.progrema.mkos;

import com.progrema.mkos.entities.expensepayment.ExpensePayment;
import com.progrema.mkos.repositories.ExpensePaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryExpensePaymentTests {

    @Autowired
    private ExpensePaymentRepository expensePaymentRepository;

    @BeforeEach
    void init() {
        expensePaymentRepository.deleteAll();
    }

    @Test
    void clear() {
        // do nothing
    }

    @Test
    void testCreateExpensePayment01() {
        {
            ExpensePayment expensePayment1 = new ExpensePayment();
            expensePayment1.setPaymentTimestamp(202001L);
            expensePayment1.setPaymentAmount(250000L);
            expensePayment1.setPaymentInformation("This is for expense water 2020 Jan");
            expensePayment1.setExpenseType("Water");
            expensePayment1.setExpenseInformation("Rekening : 12344567");
            expensePaymentRepository.save(expensePayment1);

            ExpensePayment expensePayment2 = new ExpensePayment();
            expensePayment2.setPaymentTimestamp(202001L);
            expensePayment2.setPaymentAmount(300000L);
            expensePayment2.setPaymentInformation("This is for expense electricity 2020 Jan");
            expensePayment2.setExpenseType("Electricity");
            expensePayment2.setExpenseInformation("Rekening : 567890");
            expensePaymentRepository.save(expensePayment2);

            ExpensePayment expensePayment3 = new ExpensePayment();
            expensePayment3.setPaymentTimestamp(202002L);
            expensePayment3.setPaymentAmount(300000L);
            expensePayment3.setPaymentInformation("This is for expense electricity 2020 Feb");
            expensePayment3.setExpenseType("Electricity");
            expensePayment3.setExpenseInformation("Rekening : 567890");
            expensePaymentRepository.save(expensePayment3);
        }
        {
            List<ExpensePayment> expensePayments2020Jan = expensePaymentRepository.findByPaymentTimestampOrderByExpenseType(202001L);
            assertEquals(2, expensePayments2020Jan.size());

            ExpensePayment expensePayment1 = expensePayments2020Jan.get(0);
            assertEquals(202001L, expensePayment1.getPaymentTimestamp());
            assertEquals(300000L, expensePayment1.getPaymentAmount());
            assertEquals("Electricity", expensePayment1.getExpenseType());
            assertEquals("This is for expense electricity 2020 Jan", expensePayment1.getPaymentInformation());
            assertEquals("Rekening : 567890", expensePayment1.getExpenseInformation());

            ExpensePayment expensePayment2 = expensePayments2020Jan.get(1);
            assertEquals(202001L, expensePayment2.getPaymentTimestamp());
            assertEquals(250000L, expensePayment2.getPaymentAmount());
            assertEquals("Water", expensePayment2.getExpenseType());
            assertEquals("This is for expense water 2020 Jan", expensePayment2.getPaymentInformation());
            assertEquals("Rekening : 12344567", expensePayment2.getExpenseInformation());

            List<ExpensePayment> expensePayments2020Feb = expensePaymentRepository.findByPaymentTimestampOrderByExpenseType(202002L);
            assertEquals(1, expensePayments2020Feb.size());

            ExpensePayment expensePayment3 = expensePayments2020Feb.get(0);
            assertEquals(202002L, expensePayment3.getPaymentTimestamp());
            assertEquals(300000L, expensePayment3.getPaymentAmount());
            assertEquals("Electricity", expensePayment3.getExpenseType());
            assertEquals("This is for expense electricity 2020 Feb", expensePayment3.getPaymentInformation());
            assertEquals("Rekening : 567890", expensePayment3.getExpenseInformation());
        }
    }



}
