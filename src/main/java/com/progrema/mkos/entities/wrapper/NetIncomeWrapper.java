package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.NetIncome;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetIncomeWrapper {

    private final NetIncome netIncome;

    public NetIncomeWrapper(NetIncome netIncome) {
        this.netIncome = netIncome;
    }
}
