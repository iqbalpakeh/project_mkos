package com.progrema.mkos.controller.revenuepayment;

import com.progrema.mkos.controller.revenuepayment.wrapper.RevenuePaymentWrapper;
import com.progrema.mkos.services.RevenuePaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevenuePaymentController {

    private final RevenuePaymentService revenuePaymentService;

    public RevenuePaymentController(RevenuePaymentService revenuePaymentService) {
        this.revenuePaymentService = revenuePaymentService;
    }

    @GetMapping("/api/revenue-payments-range")
    public List<RevenuePaymentWrapper> getIncomePayments(@RequestParam String year,
                                                         @RequestParam String startMonth,
                                                         @RequestParam String endMonth) {
        return revenuePaymentService.getRevenuePayments(year, startMonth, endMonth);
    }

    // RevenuePayment revenuePayment1 = new RevenuePayment();
    //     revenuePayment1.setPaymentTimestamp(202009L);
    //     revenuePayment1.setPaymentAmount(600000L);
    //     revenuePayment1.setPaymentInformation("Income payment from Room D");
    //     revenuePayment1.setRoomNumber("D");
    //     revenuePayment1.setRoomRate(600000L);
    //     revenuePayment1.setRoomInformation("Room number D");
    //     revenuePayment1.setTenantName("Moh Irfan B");
    //     revenuePayment1.setTenantPhone("087812668017");
    //     revenuePaymentRepository.save(revenuePayment1);
}
