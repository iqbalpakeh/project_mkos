package com.progrema.mkos.controller;

import com.progrema.mkos.entities.wrapper.NetIncomeWrapper;
import com.progrema.mkos.services.NetIncomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetIncomeController {

    private final NetIncomeService netIncomeService;

    public NetIncomeController(NetIncomeService netIncomeService) {
        this.netIncomeService = netIncomeService;
    }

    @GetMapping("/api/net-income-range")
    public List<NetIncomeWrapper> getNetIncomes(@RequestParam String year,
                                                @RequestParam String startMonth,
                                                @RequestParam String endMonth) {
        return netIncomeService.getNetIncomes(year, startMonth, endMonth);
    }

}
