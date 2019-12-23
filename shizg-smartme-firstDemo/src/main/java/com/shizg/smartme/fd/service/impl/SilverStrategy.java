package com.shizg.smartme.fd.service.impl;

import com.shizg.smartme.fd.annotation.MenberStrategyAnnotation;
import com.shizg.smartme.fd.enums.MenberTypes;
import com.shizg.smartme.fd.service.PriceStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@MenberStrategyAnnotation(type=MenberTypes.SILVER)
public class SilverStrategy implements PriceStrategy {
    @Override
    public BigDecimal priceCompute(BigDecimal moneuy) {
        //白银会员9折
        return moneuy.multiply(new BigDecimal(0.9));
    }

    @Override
    public int getType() {
        return MenberTypes.SILVER.getType();
    }
}
