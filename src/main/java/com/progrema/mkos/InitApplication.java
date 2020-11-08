package com.progrema.mkos;

import com.progrema.mkos.entities.db.Expense;
import com.progrema.mkos.repositories.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApplication implements CommandLineRunner {

    private final ExpenseRepository expenseRepository;

    public InitApplication(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        clearDatabase();
        populateDatabase();
    }

    private void clearDatabase() {
        expenseRepository.deleteAll();
    }

    private void populateDatabase() {
        Expense expense1 = new Expense();
        expense1.setExpenseType("Water");
        expense1.setExpenseInformation("Rekening : 12344567");
        expenseRepository.save(expense1);

        Expense expense2 = new Expense();
        expense2.setExpenseType("Electricity");
        expense2.setExpenseInformation("Rekening : 567890");
        expenseRepository.save(expense2);
    }

}
