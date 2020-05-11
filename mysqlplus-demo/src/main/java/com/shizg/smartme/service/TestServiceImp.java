package com.shizg.smartme.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shizg.smartme.domin.DeviceData;
import com.shizg.smartme.mapper.DeviceStatusMapper;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp extends ServiceImpl<DeviceStatusMapper, DeviceData> implements TestService {
}
