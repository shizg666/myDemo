package com.shizg.smartme.fd.service;

import java.math.BigDecimal;

public interface PriceStrategy {
    BigDecimal priceCompute(BigDecimal moneuy);

    int getType();
}
