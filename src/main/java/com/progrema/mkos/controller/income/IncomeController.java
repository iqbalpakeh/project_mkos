package com.progrema.mkos.controller.income;

import com.progrema.mkos.controller.income.wrapper.IncomeWrapper;
import com.progrema.mkos.services.IncomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/api/incomes-range")
    public List<IncomeWrapper> getNetIncomes(@RequestParam String year,
                                             @RequestParam String startMonth,
                                             @RequestParam String endMonth) {
        return incomeService.getNetIncomes(year, startMonth, endMonth);
    }

}
