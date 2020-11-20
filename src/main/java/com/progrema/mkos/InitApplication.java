package com.progrema.mkos;

import com.progrema.mkos.entities.*;
import com.progrema.mkos.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApplication implements CommandLineRunner {

    private ExpenseRepository expenseRepository;
    private ExpensePaymentRepository expensePaymentRepository;
    private RevenuePaymentRepository revenuePaymentRepository;
    private RoomRepository roomRepository;
    private TenantLogRepository tenantLogRepository;
    private TenantRepository tenantRepository;

    public InitApplication(ExpenseRepository expenseRepository,
                           ExpensePaymentRepository expensePaymentRepository,
                           RevenuePaymentRepository revenuePaymentRepository,
                           RoomRepository roomRepository,
                           TenantLogRepository tenantLogRepository,
                           TenantRepository tenantRepository) {
        this.expenseRepository = expenseRepository;
        this.expensePaymentRepository = expensePaymentRepository;
        this.revenuePaymentRepository = revenuePaymentRepository;
        this.roomRepository = roomRepository;
        this.tenantLogRepository = tenantLogRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // clearDatabase();
        // populateDatabase02();
    }

    private void clearDatabase() {
        expenseRepository.deleteAll();
        expensePaymentRepository.deleteAll();
        revenuePaymentRepository.deleteAll();
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
            tenant.setCheckin(202009L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Luthfi");
            tenant.setTenantPhone("087725595557");
            tenant.setCheckin(202009L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Irfan");
            tenant.setTenantPhone("085721122232");
            tenant.setCheckin(202009L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Lucky");
            tenant.setTenantPhone("08982226396");
            tenant.setCheckin(202009L);
            tenantRepository.save(tenant);
        }
        {
            Tenant tenant = new Tenant();
            tenant.setTenantName("Irgi");
            tenant.setTenantPhone("089661101420");
            tenant.setCheckin(202009L);
            tenantRepository.save(tenant);
        }

        // -----------------------------
        // Assign tenant to room
        // -----------------------------

        {
            Room room = roomRepository.findByRoomNumber("D").get(0);
            Tenant tenant = tenantRepository.findByTenantName("Moh Irfan B").get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
        }

        {
            Room room = roomRepository.findByRoomNumber("E").get(0);
            Tenant tenant = tenantRepository.findByTenantName("Luthfi").get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
        }

        {
            Room room = roomRepository.findByRoomNumber("J").get(0);
            Tenant tenant = tenantRepository.findByTenantName("Irfan").get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
        }

        {
            Room room = roomRepository.findByRoomNumber("K").get(0);
            Tenant tenant = tenantRepository.findByTenantName("Lucky").get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
        }

        {
            Room room = roomRepository.findByRoomNumber("L").get(0);
            Tenant tenant = tenantRepository.findByTenantName("Irgi").get(0);
            room.setTenant(tenant);
            roomRepository.save(room);
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

        RevenuePayment revenuePayment1 = new RevenuePayment();
        revenuePayment1.setPaymentTimestamp(202009L);
        revenuePayment1.setPaymentAmount(600000L);
        revenuePayment1.setPaymentInformation("Income payment from Room D");
        revenuePayment1.setRoomNumber("D");
        revenuePayment1.setRoomRate(600000L);
        revenuePayment1.setRoomInformation("Room number D");
        revenuePayment1.setTenantName("Moh Irfan B");
        revenuePayment1.setTenantPhone("087812668017");
        revenuePaymentRepository.save(revenuePayment1);

        RevenuePayment revenuePayment2 = new RevenuePayment();
        revenuePayment2.setPaymentTimestamp(202010L);
        revenuePayment2.setPaymentAmount(600000L);
        revenuePayment2.setPaymentInformation("Income payment from Room D");
        revenuePayment2.setRoomNumber("D");
        revenuePayment2.setRoomRate(600000L);
        revenuePayment2.setRoomInformation("Room number D");
        revenuePayment2.setTenantName("Moh Irfan B");
        revenuePayment2.setTenantPhone("087812668017");
        revenuePaymentRepository.save(revenuePayment2);

        RevenuePayment revenuePayment3 = new RevenuePayment();
        revenuePayment3.setPaymentTimestamp(202009L);
        revenuePayment3.setPaymentAmount(600000L);
        revenuePayment3.setPaymentInformation("Income payment from Room E");
        revenuePayment3.setRoomNumber("E");
        revenuePayment3.setRoomRate(600000L);
        revenuePayment3.setRoomInformation("Room number E");
        revenuePayment3.setTenantName("Luthfi");
        revenuePayment3.setTenantPhone("087725595557");
        revenuePaymentRepository.save(revenuePayment3);

        RevenuePayment revenuePayment4 = new RevenuePayment();
        revenuePayment4.setPaymentTimestamp(202010L);
        revenuePayment4.setPaymentAmount(600000L);
        revenuePayment4.setPaymentInformation("Income payment from Room E");
        revenuePayment4.setRoomNumber("E");
        revenuePayment4.setRoomRate(600000L);
        revenuePayment4.setRoomInformation("Room number E");
        revenuePayment4.setTenantName("Luthfi");
        revenuePayment4.setTenantPhone("087725595557");
        revenuePaymentRepository.save(revenuePayment4);

        RevenuePayment revenuePayment5 = new RevenuePayment();
        revenuePayment5.setPaymentTimestamp(202009L);
        revenuePayment5.setPaymentAmount(600000L);
        revenuePayment5.setPaymentInformation("Income payment from Room J");
        revenuePayment5.setRoomNumber("J");
        revenuePayment5.setRoomRate(600000L);
        revenuePayment5.setRoomInformation("Room number J");
        revenuePayment5.setTenantName("Irfan");
        revenuePayment5.setTenantPhone("085721122232");
        revenuePaymentRepository.save(revenuePayment5);

        RevenuePayment revenuePayment6 = new RevenuePayment();
        revenuePayment6.setPaymentTimestamp(202010L);
        revenuePayment6.setPaymentAmount(600000L);
        revenuePayment6.setPaymentInformation("Income payment from Room J");
        revenuePayment6.setRoomNumber("J");
        revenuePayment6.setRoomRate(600000L);
        revenuePayment6.setRoomInformation("Room number J");
        revenuePayment6.setTenantName("Irfan");
        revenuePayment6.setTenantPhone("085721122232");
        revenuePaymentRepository.save(revenuePayment6);

        RevenuePayment revenuePayment7 = new RevenuePayment();
        revenuePayment7.setPaymentTimestamp(202009L);
        revenuePayment7.setPaymentAmount(650000L);
        revenuePayment7.setPaymentInformation("Income payment from Room K");
        revenuePayment7.setRoomNumber("K");
        revenuePayment7.setRoomRate(650000L);
        revenuePayment7.setRoomInformation("Room number K");
        revenuePayment7.setTenantName("Lucky");
        revenuePayment7.setTenantPhone("08982226396");
        revenuePaymentRepository.save(revenuePayment7);

        RevenuePayment revenuePayment8 = new RevenuePayment();
        revenuePayment8.setPaymentTimestamp(202010L);
        revenuePayment8.setPaymentAmount(0L);
        revenuePayment8.setPaymentInformation("Income payment from Room K");
        revenuePayment8.setRoomNumber("K");
        revenuePayment8.setRoomRate(650000L);
        revenuePayment8.setRoomInformation("Room number K");
        revenuePayment8.setTenantName("Lucky");
        revenuePayment8.setTenantPhone("08982226396");
        revenuePaymentRepository.save(revenuePayment8);

        RevenuePayment revenuePayment9 = new RevenuePayment();
        revenuePayment9.setPaymentTimestamp(202009L);
        revenuePayment9.setPaymentAmount(550000L);
        revenuePayment9.setPaymentInformation("Income payment from Room L");
        revenuePayment9.setRoomNumber("L");
        revenuePayment9.setRoomRate(550000L);
        revenuePayment9.setRoomInformation("Room number L");
        revenuePayment9.setTenantName("Irgi");
        revenuePayment9.setTenantPhone("089661101420");
        revenuePaymentRepository.save(revenuePayment9);

        RevenuePayment revenuePayment10 = new RevenuePayment();
        revenuePayment10.setPaymentTimestamp(202010L);
        revenuePayment10.setPaymentAmount(550000L);
        revenuePayment10.setPaymentInformation("Income payment from Room L");
        revenuePayment10.setRoomNumber("L");
        revenuePayment10.setRoomRate(550000L);
        revenuePayment10.setRoomInformation("Room number L");
        revenuePayment10.setTenantName("Irgi");
        revenuePayment10.setTenantPhone("089661101420");
        revenuePaymentRepository.save(revenuePayment10);
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
