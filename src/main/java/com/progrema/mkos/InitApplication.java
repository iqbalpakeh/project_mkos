package com.progrema.mkos;

import com.progrema.mkos.entities.db.*;
import com.progrema.mkos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApplication implements CommandLineRunner {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpensePaymentRepository expensePaymentRepository;

    @Autowired
    private IncomePaymentRepository incomePaymentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TenantLogRepository tenantLogRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public void run(String... args) throws Exception {
        clearDatabase();
        populateDatabase01();
    }

    private void clearDatabase() {
        expenseRepository.deleteAll();
        expensePaymentRepository.deleteAll();
        incomePaymentRepository.deleteAll();
        roomRepository.deleteAll();
        tenantLogRepository.deleteAll();
        tenantRepository.deleteAll();
    }

    private void populateDatabase01() {
        {
            Expense expense1 = new Expense();
            expense1.setExpenseType("Water");
            expense1.setExpenseInformation("Rekening : 12344567");
            expenseRepository.save(expense1);

            Expense expense2 = new Expense();
            expense2.setExpenseType("Electricity");
            expense2.setExpenseInformation("Rekening : 567890");
            expenseRepository.save(expense2);
        }
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
        }
        {
            {
                Tenant tenant = new Tenant();
                tenant.setTenantName("M Lutfi");
                tenant.setTenantPhone("081811112222");
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
        }
    }

}
