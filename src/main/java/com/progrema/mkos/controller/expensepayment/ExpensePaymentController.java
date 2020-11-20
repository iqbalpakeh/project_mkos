package com.progrema.mkos.controller.expensepayment;

import com.progrema.mkos.controller.expensepayment.wrapper.ExpensePaymentWrapper;
import com.progrema.mkos.services.ExpensePaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensePaymentController {

    private final ExpensePaymentService expensePaymentService;

    public ExpensePaymentController(ExpensePaymentService expensePaymentService) {
        this.expensePaymentService = expensePaymentService;
    }

    @GetMapping("/api/expense-payments-range")
    public List<ExpensePaymentWrapper> getExpensePayments(@RequestParam String year,
                                                          @RequestParam String startMonth,
                                                          @RequestParam String endMonth) {
        return expensePaymentService.getExpensePayments(year, startMonth, endMonth);
    }

    // ExpensePayment expensePayment1 = new ExpensePayment();
    //     expensePayment1.setPaymentTimestamp(202009L);
    //     expensePayment1.setPaymentAmount(309428L);
    //     expensePayment1.setPaymentInformation("This is for expense water 2020 September");
    //     expensePayment1.setExpenseType("Water Bill");
    //     expensePayment1.setExpenseInformation("No Pelanggan: 535590803466");
    //     expensePaymentRepository.save(expensePayment1);



}
