package com.shizg.smartme.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shizg.smartme.domin.SmarthomeAddress;
import com.shizg.smartme.dynamic.AnotherDatasource;
import com.shizg.smartme.dynamic.ContextDatasourceTypeHolder;
import com.shizg.smartme.mapper.SmarthomeAddressMapper;
import org.springframework.stereotype.Service;

@Service
public class TestBServiceImp extends ServiceImpl<SmarthomeAddressMapper, SmarthomeAddress> implements TestBService {

    @AnotherDatasource("master")
    @Override
    public void test(String address) {
        SmarthomeAddress smarthomeAddress = getById(address);
        System.out.println("123213");
    }

}
