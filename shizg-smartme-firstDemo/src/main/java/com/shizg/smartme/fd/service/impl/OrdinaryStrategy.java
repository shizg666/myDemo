package com.shizg.smartme.fd.service.impl;

import com.shizg.smartme.fd.annotation.MenberStrategyAnnotation;
import com.shizg.smartme.fd.enums.MenberTypes;
import com.shizg.smartme.fd.service.PriceStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@MenberStrategyAnnotation(type=MenberTypes.ORDINARY)
public class OrdinaryStrategy implements PriceStrategy {
    @Override
    public BigDecimal priceCompute(BigDecimal moneuy) {
        //普通会员不打折
        return moneuy;
    }

    @Override
    public int getType() {
        return MenberTypes.ORDINARY.getType();
    }
}
