package com.shizg.smartme.fd.controller;

import com.shizg.smartme.fd.factory.PriceStrategyFactory;
import com.shizg.smartme.fd.service.PriceStrategy;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/test/")
public class StrategyTestController {

    @ApiOperation(value = "测试策略模式", notes = "", consumes = "application/json")
    @GetMapping(value = "/get-price-by-type")
    public Long getPrice(int type,Long money){
        PriceStrategy priceStrategy = PriceStrategyFactory.getInstance().get(type);
        return priceStrategy.priceCompute(new BigDecimal(money)).longValue();
    }
}
