package com.progrema.mkos.services;

import org.springframework.stereotype.Service;

@Service
public class TimestampServiceImpl implements TimestampService {

    @Override
    public String convertMonth(long index) {
        switch ((int) index) {
            case 1: return "01";
            case 2: return "02";
            case 3: return "03";
            case 4: return "04";
            case 5: return "05";
            case 6: return "06";
            case 7: return "07";
            case 8: return "08";
            case 9: return "09";
            case 10: return "10";
            case 11: return "11";
            case 12: return "12";
            default: throw new RuntimeException("Not valid month");
        }
    }
}
