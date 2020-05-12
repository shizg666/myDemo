package com.shizg.smartme.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shizg.smartme.domin.SmarthomeAddress;
import com.shizg.smartme.dynamic.AnotherDatasource;
import com.shizg.smartme.dynamic.ContextDatasourceTypeHolder;
import com.shizg.smartme.mapper.SmarthomeAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp extends ServiceImpl<SmarthomeAddressMapper, SmarthomeAddress> implements TestService {

    @Autowired
    private TestBService testBService;

    @AnotherDatasource("slave")
    @Override
    public void test(String address) {
        SmarthomeAddress smarthomeAddress = getById(address);
        a1(address);
        a2(address);
        testBService.test(address);
    }
    @AnotherDatasource("master")
    private void a1(String address) {
        SmarthomeAddress smarthomeAddress = getById(address);
        System.out.println("123213");
    }

    private void a2(String address) {
        ContextDatasourceTypeHolder.setDatasourceType("master");
        SmarthomeAddress smarthomeAddress = getById(address);
        System.out.println("123213");
    }
}
