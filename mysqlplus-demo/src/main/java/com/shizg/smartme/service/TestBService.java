package com.shizg.smartme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shizg.smartme.domin.SmarthomeAddress;

public interface TestBService extends IService<SmarthomeAddress> {
    void test(String address);
}
