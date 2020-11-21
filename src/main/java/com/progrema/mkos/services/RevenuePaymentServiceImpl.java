package com.progrema.mkos.services;

import com.progrema.mkos.entities.revenuepayment.RevenuePayment;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentCreatorWrapper;
import com.progrema.mkos.entities.revenuepayment.wrapper.RevenuePaymentWrapper;
import com.progrema.mkos.entities.room.Room;
import com.progrema.mkos.entities.tenant.Tenant;
import com.progrema.mkos.repositories.RevenuePaymentRepository;
import com.progrema.mkos.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevenuePaymentServiceImpl implements RevenuePaymentService {

    private final RevenuePaymentRepository revenuePaymentRepository;
    private final RoomRepository roomRepository;
    private final TimestampService timestampService;

    public RevenuePaymentServiceImpl(RevenuePaymentRepository revenuePaymentRepository,
                                     RoomRepository roomRepository,
                                     TimestampService timestampService) {
        this.revenuePaymentRepository = revenuePaymentRepository;
        this.roomRepository = roomRepository;
        this.timestampService = timestampService;
    }

    @Override
    public List<RevenuePaymentWrapper> getRevenuePayments(String year, String startMonth, String endMonth) {
        List<RevenuePaymentWrapper> revenuePaymentWrappers = new ArrayList<>();
        for (long i = Long.parseLong(startMonth); i <= Long.parseLong(endMonth); i++) {
            long timestamp = timestampService.timestamp(year, i);
            RevenuePaymentWrapper revenuePaymentWrapper = new RevenuePaymentWrapper(timestamp);
            revenuePaymentRepository.findByPaymentTimestamp(timestamp).forEach(revenuePaymentWrapper::addRevenuePayment);
            revenuePaymentWrappers.add(revenuePaymentWrapper);
        }
        return revenuePaymentWrappers;
    }

    @Override
    public RevenuePayment createRevenuePayment(RevenuePaymentCreatorWrapper wrapper) {
        Room room = roomRepository.findByRoomNumber(wrapper.getRoomNumber()).get(0);
        Tenant tenant = room.getTenant();

        RevenuePayment revenuePayment = new RevenuePayment();
        revenuePayment.setPaymentTimestamp(wrapper.getPaymentTimestamp());
        revenuePayment.setPaymentAmount(wrapper.getPaymentAmount());
        revenuePayment.setPaymentInformation(wrapper.getPaymentInformation());
        revenuePayment.setRoomNumber(room.getRoomNumber());
        revenuePayment.setRoomRate(room.getRoomRate());
        revenuePayment.setRoomInformation(room.getRoomInformation());
        revenuePayment.setTenantName(tenant.getTenantName());
        revenuePayment.setTenantPhone(tenant.getTenantPhone());
        return revenuePaymentRepository.save(revenuePayment);
    }
}
