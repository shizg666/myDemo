package com.shizg.smartme.fd.factory;

import com.google.common.collect.Maps;
import com.shizg.smartme.fd.annotation.MenberStrategyAnnotation;
import com.shizg.smartme.fd.service.PriceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@Slf4j
public class PriceStrategyFactory {

    @Autowired
    private Map<String, PriceStrategy> priceStrategyMap;

    private static Map<Integer,PriceStrategy> dataMap = Maps.newHashMap();

    public PriceStrategyFactory(){
        log.info("初始化");
//        for (Map.Entry<String, PriceStrategy> entry : priceStrategyMap.entrySet()) {
//            //获取service实现类上注解的type
//            MenberStrategyAnnotation annotation = entry.getValue().getClass().getAnnotation(MenberStrategyAnnotation.class);
//            if(annotation == null){
//                continue;
//            }
//            Integer memberType = annotation.type().getType();
//            dataMap.put(memberType,entry.getValue());
//        }
    }

    @PostConstruct
    public void init() {
        for (Map.Entry<String, PriceStrategy> entry : priceStrategyMap.entrySet()) {
            //获取service实现类上注解的type
            MenberStrategyAnnotation annotation = entry.getValue().getClass().getAnnotation(MenberStrategyAnnotation.class);
            if(annotation == null){
                continue;
            }
            Integer memberType = annotation.type().getType();
            dataMap.put(memberType,entry.getValue());
        }
    }

    public static class Holder {
        public static PriceStrategyFactory instance = new PriceStrategyFactory();
    }

    public static PriceStrategyFactory getInstance() {
        return Holder.instance;
    }

    public PriceStrategy get(Integer type) {
        return dataMap.get(type);
    }
}
