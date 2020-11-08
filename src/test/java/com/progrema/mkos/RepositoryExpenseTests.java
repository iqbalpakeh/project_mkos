package com.progrema.mkos;

import com.progrema.mkos.entities.db.Expense;
import com.progrema.mkos.repositories.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepositoryExpenseTests {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Test
	void testCreateExpense01() {
		Expense expense = new Expense();
		expense.setExpenseType("Water");
		expense.setExpenseInformation("Rekening : 12344567");

		expenseRepository.save(expense);
	}

}
