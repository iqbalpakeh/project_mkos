package com.progrema.mkos;

import com.progrema.mkos.entities.db.*;
import com.progrema.mkos.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApplication implements CommandLineRunner {

    private ExpenseRepository expenseRepository;
    private ExpensePaymentRepository expensePaymentRepository;
    private IncomePaymentRepository incomePaymentRepository;
    private RoomRepository roomRepository;
    private TenantLogRepository tenantLogRepository;
    private TenantRepository tenantRepository;

    public InitApplication(ExpenseRepository expenseRepository,
                           ExpensePaymentRepository expensePaymentRepository,
                           IncomePaymentRepository incomePaymentRepository,
                           RoomRepository roomRepository,
                           TenantLogRepository tenantLogRepository,
                           TenantRepository tenantRepository) {
        this.expenseRepository = expenseRepository;
        this.expensePaymentRepository = expensePaymentRepository;
        this.incomePaymentRepository = incomePaymentRepository;
        this.roomRepository = roomRepository;
        this.tenantLogRepository = tenantLogRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        clearDatabase();
        populateDatabase02();
    }

    private void clearDatabase() {
        expenseRepository.deleteAll();
        expensePaymentRepository.deleteAll();
        incomePaymentRepository.deleteAll();
        roomRepository.deleteAll();
        tenantLogRepository.deleteAll();
        tenantRepository.deleteAll();
    }

    private void populateDatabase02() {

        // -----------------------------
        // Create Expense
        // -----------------------------

        Expense expense1 = new Expense();
        expense1.setExpenseType("Water Bill");
        expense1.setExpenseInformation("No Pelanggan: 535590803466");
        expenseRepository.save(expense1);

        Expense expense2 = new Expense();
        expense2.setExpenseType("Electricity Bill");
        expense2.setExpenseInformation("No Pelanggan : 102290302");
        expenseRepository.save(expense2);

        // -----------------------------
        // Create Rooms
        // -----------------------------

        String[] numbers = {
                "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S"
        };

        for (String number: numbers) {
            Room room = new Room();
            room.setRoomNumber(number);
            if (number.equals("K")) {
                room.setRoomRate(650000L);
            } else if (number.equals("L")) {
                room.setRoomRate(550000L);
            } else {
                room.setRoomRate(600000L);
            }
            room.setRoomInformation("Room number " + number);
            roomRepository.save(room);
        }

        // -----------------------------
        // Create Tenants
        // -----------------------------

        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Moh Irfan B");
            tenant.setTenantPhone("087812668017");
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Luthfi");
            tenant.setTenantPhone("087725595557");
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Irfan");
            tenant.setTenantPhone("085721122232");
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Lucky");
            tenant.setTenantPhone("0898-222-6396");
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Irgi");
            tenant.setTenantPhone("089661101420");
            tenantRepository.save(tenant);
        }

        // -----------------------------
        // Create Expense Payment
        // -----------------------------

        ExpensePayment expensePayment1 = new ExpensePayment();
        expensePayment1.setPaymentTimestamp(202009L);
        expensePayment1.setPaymentAmount(309428L);
        expensePayment1.setPaymentInformation("This is for expense water 2020 September");
        expensePayment1.setExpenseType("Water Bill");
        expensePayment1.setExpenseInformation("No Pelanggan: 535590803466");
        expensePaymentRepository.save(expensePayment1);

        ExpensePayment expensePayment2 = new ExpensePayment();
        expensePayment2.setPaymentTimestamp(202009L);
        expensePayment2.setPaymentAmount(80909L);
        expensePayment2.setPaymentInformation("This is for expense electricity 2020 September");
        expensePayment2.setExpenseType("Electricity Bill");
        expensePayment2.setExpenseInformation("No Pelanggan : 102290302");
        expensePaymentRepository.save(expensePayment2);

        ExpensePayment expensePayment3 = new ExpensePayment();
        expensePayment3.setPaymentTimestamp(202010L);
        expensePayment3.setPaymentAmount(295000L);
        expensePayment3.setPaymentInformation("This is for expense water 2020 October");
        expensePayment3.setExpenseType("Water Bill");
        expensePayment3.setExpenseInformation("No Pelanggan: 535590803466");
        expensePaymentRepository.save(expensePayment3);

        ExpensePayment expensePayment4 = new ExpensePayment();
        expensePayment4.setPaymentTimestamp(202010L);
        expensePayment4.setPaymentAmount(80805L);
        expensePayment4.setPaymentInformation("This is for expense electricity 2020 October");
        expensePayment4.setExpenseType("Electricity Bill");
        expensePayment4.setExpenseInformation("No Pelanggan : 102290302");
        expensePaymentRepository.save(expensePayment4);

        // -----------------------------
        // Create Income Payment
        // -----------------------------

        IncomePayment incomePayment1 = new IncomePayment();
        incomePayment1.setPaymentTimestamp(202009L);
        incomePayment1.setPaymentAmount(600000L);
        incomePayment1.setPaymentInformation("Income payment from Room D");
        incomePayment1.setRoomNumber("D");
        incomePayment1.setRoomRate(600000L);
        incomePayment1.setRoomInformation("Room number D");
        incomePayment1.setTenantName("Moh Irfan B");
        incomePayment1.setTenantPhone("087812668017");
        incomePaymentRepository.save(incomePayment1);

        IncomePayment incomePayment2 = new IncomePayment();
        incomePayment2.setPaymentTimestamp(202010L);
        incomePayment2.setPaymentAmount(600000L);
        incomePayment2.setPaymentInformation("Income payment from Room D");
        incomePayment2.setRoomNumber("D");
        incomePayment2.setRoomRate(600000L);
        incomePayment2.setRoomInformation("Room number D");
        incomePayment2.setTenantName("Moh Irfan B");
        incomePayment2.setTenantPhone("087812668017");
        incomePaymentRepository.save(incomePayment2);

        IncomePayment incomePayment3 = new IncomePayment();
        incomePayment3.setPaymentTimestamp(202009L);
        incomePayment3.setPaymentAmount(600000L);
        incomePayment3.setPaymentInformation("Income payment from Room E");
        incomePayment3.setRoomNumber("E");
        incomePayment3.setRoomRate(600000L);
        incomePayment3.setRoomInformation("Room number E");
        incomePayment3.setTenantName("Luthfi");
        incomePayment3.setTenantPhone("087725595557");
        incomePaymentRepository.save(incomePayment3);

        IncomePayment incomePayment4 = new IncomePayment();
        incomePayment4.setPaymentTimestamp(202010L);
        incomePayment4.setPaymentAmount(600000L);
        incomePayment4.setPaymentInformation("Income payment from Room E");
        incomePayment4.setRoomNumber("E");
        incomePayment4.setRoomRate(600000L);
        incomePayment4.setRoomInformation("Room number E");
        incomePayment4.setTenantName("Luthfi");
        incomePayment4.setTenantPhone("087725595557");
        incomePaymentRepository.save(incomePayment4);

        IncomePayment incomePayment5 = new IncomePayment();
        incomePayment5.setPaymentTimestamp(202009L);
        incomePayment5.setPaymentAmount(600000L);
        incomePayment5.setPaymentInformation("Income payment from Room J");
        incomePayment5.setRoomNumber("J");
        incomePayment5.setRoomRate(600000L);
        incomePayment5.setRoomInformation("Room number J");
        incomePayment5.setTenantName("Irfan");
        incomePayment5.setTenantPhone("085721122232");
        incomePaymentRepository.save(incomePayment5);

        IncomePayment incomePayment6 = new IncomePayment();
        incomePayment6.setPaymentTimestamp(202010L);
        incomePayment6.setPaymentAmount(600000L);
        incomePayment6.setPaymentInformation("Income payment from Room J");
        incomePayment6.setRoomNumber("J");
        incomePayment6.setRoomRate(600000L);
        incomePayment6.setRoomInformation("Room number J");
        incomePayment6.setTenantName("Irfan");
        incomePayment6.setTenantPhone("085721122232");
        incomePaymentRepository.save(incomePayment6);

        IncomePayment incomePayment7 = new IncomePayment();
        incomePayment7.setPaymentTimestamp(202009L);
        incomePayment7.setPaymentAmount(650000L);
        incomePayment7.setPaymentInformation("Income payment from Room K");
        incomePayment7.setRoomNumber("K");
        incomePayment7.setRoomRate(650000L);
        incomePayment7.setRoomInformation("Room number K");
        incomePayment7.setTenantName("Lucky");
        incomePayment7.setTenantPhone("08982226396");
        incomePaymentRepository.save(incomePayment7);

        IncomePayment incomePayment8 = new IncomePayment();
        incomePayment8.setPaymentTimestamp(202010L);
        incomePayment8.setPaymentAmount(0L);
        incomePayment8.setPaymentInformation("Income payment from Room K");
        incomePayment8.setRoomNumber("K");
        incomePayment8.setRoomRate(650000L);
        incomePayment8.setRoomInformation("Room number K");
        incomePayment8.setTenantName("Lucky");
        incomePayment8.setTenantPhone("08982226396");
        incomePaymentRepository.save(incomePayment8);

        IncomePayment incomePayment9 = new IncomePayment();
        incomePayment9.setPaymentTimestamp(202009L);
        incomePayment9.setPaymentAmount(550000L);
        incomePayment9.setPaymentInformation("Income payment from Room L");
        incomePayment9.setRoomNumber("K");
        incomePayment9.setRoomRate(550000L);
        incomePayment9.setRoomInformation("Room number L");
        incomePayment9.setTenantName("Irgi");
        incomePayment9.setTenantPhone("089661101420");
        incomePaymentRepository.save(incomePayment9);

        IncomePayment incomePayment10 = new IncomePayment();
        incomePayment10.setPaymentTimestamp(202010L);
        incomePayment10.setPaymentAmount(550000L);
        incomePayment10.setPaymentInformation("Income payment from Room L");
        incomePayment10.setRoomNumber("K");
        incomePayment10.setRoomRate(550000L);
        incomePayment10.setRoomInformation("Room number L");
        incomePayment10.setTenantName("Irgi");
        incomePayment10.setTenantPhone("089661101420");
        incomePaymentRepository.save(incomePayment10);
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
            tenantLog2.setTenantName("Aziza Ayunindya");
            tenantLog2.setTenantPhone("081808488442");
            tenantLog2.setRoomNumber("D");
            tenantLogRepository.save(tenantLog2);
        }
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
    }

}
