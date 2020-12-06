package com.progrema.mkos.controller;

import com.progrema.mkos.entities.income.wrapper.IncomeWrapper;
import com.progrema.mkos.services.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeController {

    private final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/api/incomes-range")
    public List<IncomeWrapper> getNetIncomes(@RequestParam String year,
                                             @RequestParam String startMonth,
                                             @RequestParam String endMonth) {
        logger.info("getNetIncomes(year = {}, startMonth = {}, endMonth = {})", year, startMonth, endMonth);
        return incomeService.getNetIncomes(year, startMonth, endMonth);
    }

}
