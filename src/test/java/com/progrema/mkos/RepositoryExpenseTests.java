package com.progrema.mkos;

import com.progrema.mkos.entities.Expense;
import com.progrema.mkos.repositories.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RepositoryExpenseTests {

	@Autowired
	private ExpenseRepository expenseRepository;

	@BeforeEach
	void init() {
		expenseRepository.deleteAll();
	}

	@Test
	void clear() {
		// do nothing
	}

	@Test
	void testCreateExpense01() {
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
			Expense expense1 = expenseRepository.findByExpenseType("Water").get(0);
			assertEquals(expense1.getExpenseType(), "Water");
			assertEquals(expense1.getExpenseInformation(), "Rekening : 12344567");

			Expense expense2 = expenseRepository.findByExpenseType("Electricity").get(0);
			assertEquals(expense2.getExpenseType(), "Electricity");
			assertEquals(expense2.getExpenseInformation(), "Rekening : 567890");
		}
	}

}
