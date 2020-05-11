package com.shizg.smartme.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.shizg.smartme.domin.DeviceData;
import com.shizg.smartme.domin.DeviceStatusVO;
import com.shizg.smartme.service.ProjectDataListener;
import com.shizg.smartme.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
@Slf4j
public class test {
    @Autowired
    private TestService testService;


    @GetMapping("/query")
    public String query(DeviceStatusVO deviceStatusVO) throws InterruptedException {
        QueryWrapper<DeviceData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gateway_mac", deviceStatusVO.getGatewayMac());
        queryWrapper.orderByDesc("start_time");
        Long start = System.currentTimeMillis();
        List<DeviceData> po = testService.list(queryWrapper);
        Long end = System.currentTimeMillis();
        log.error("查询结束！耗时：" + (end - start));
        return "sucess";
    }

    @GetMapping("/insert")
    public String insertData() throws InterruptedException {
        ProjectDataListener p = new ProjectDataListener(testService);
        log.error("开始插入12万数据！");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 120000; i++) {
            DeviceData deviceStatus = new DeviceData();
//            String uid = UUID.randomUUID().toString().replaceAll("-", "");
//            deviceStatus.setId(uid);
            Date date = new Date();
            deviceStatus.setStartTime(date);
            deviceStatus.setEndTime(date);
            deviceStatus.setDeviceId("" + i);
            deviceStatus.setAttrCode("switch");
            deviceStatus.setAttrVal("on");
            deviceStatus.setCategory("11");
            deviceStatus.setGatewayMac("" + i);
            p.saveData(deviceStatus);
        }
        ExecutorService executorService = p.getEs();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        Long end = System.currentTimeMillis();
        System.out.println("所有的子线程都结束了！耗时：" + (end - start));
        log.error("所有的子线程都结束了！耗时：" + (end - start));
//        while (true) {
//            if (p.getEs().isTerminated()) {
//
//                break;
//            }
//            Thread.sleep(500);
//        }
        return "sucess";
    }




    @GetMapping("/insert2/{num}")
    public String insertData11(@PathVariable(value = "num") int num) throws InterruptedException {
        ProjectDataListener p = new ProjectDataListener(testService);
        int count = num * 10000;
        log.error("开始插入"+num+"万数据！");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            DeviceData deviceStatus = new DeviceData();
//            String uid = UUID.randomUUID().toString().replaceAll("-", "");
//            deviceStatus.setId(uid);
            Date date = new Date();
            deviceStatus.setStartTime(date);
            deviceStatus.setEndTime(date);
            deviceStatus.setDeviceId("" + i);
            deviceStatus.setAttrCode("switch");
            deviceStatus.setAttrVal("on");
            deviceStatus.setCategory("11");
            deviceStatus.setGatewayMac("" + i);
            p.saveData(deviceStatus);
        }
        return "sucess"+num;
    }

    @GetMapping("/insert/{num}")
    public String insertData2(@PathVariable(value = "num") int num) throws InterruptedException {
        ProjectDataListener p = new ProjectDataListener(testService);
        List<DeviceData> deviceStatusList = new ArrayList<>();
        int count = num * 10000;
        for (int i = 0; i < count; i++) {
            DeviceData deviceStatus = new DeviceData();
//            String uid = UUID.randomUUID().toString().replaceAll("-", "");
//            deviceStatus.setId(uid);
            Date date = new Date();
            deviceStatus.setStartTime(date);
            deviceStatus.setEndTime(date);
            deviceStatus.setDeviceId("" + i);
            deviceStatus.setAttrCode("switch");
            deviceStatus.setAttrVal("on");
            deviceStatus.setCategory("11");
            deviceStatus.setGatewayMac("" + i);
            deviceStatusList.add(deviceStatus);
        }
        log.error("开始插入"+count+"万数据！");
        Long start = System.currentTimeMillis();
        deviceStatusList.forEach(o->{
            p.saveData(o);
        });
        ExecutorService executorService = p.getEs();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        Long end = System.currentTimeMillis();
//        System.out.println("所有的子线程都结束了！耗时：" + (end - start));
        log.error("所有的子线程都结束了！耗时：" + (end - start));
        return "sucess"+count;
    }


    @GetMapping("/insertT/{num}")
    public String insertData8(@PathVariable(value = "num") int num, @Param("gate") String gate) throws InterruptedException {
        ProjectDataListener p = new ProjectDataListener(testService);
        List<DeviceData> deviceStatusList = new ArrayList<>();
        int count = num * 10000;
        for (int i = 0; i < count; i++) {
            DeviceData deviceStatus = new DeviceData();
//            String uid = UUID.randomUUID().toString().replaceAll("-", "");
//            deviceStatus.setId(uid);
            Date date = new Date();
            deviceStatus.setStartTime(date);
            deviceStatus.setEndTime(date);
            deviceStatus.setDeviceId("" + i);
            deviceStatus.setAttrCode("switch");
            deviceStatus.setAttrVal("on");
            deviceStatus.setCategory("11");
            deviceStatus.setGatewayMac(gate);
            deviceStatusList.add(deviceStatus);
        }
        List<List<DeviceData>> data = Lists.partition(deviceStatusList,50);
        log.error("开始插入"+num+"万数据！");
        Long start = System.currentTimeMillis();
        data.forEach(o->{
            p.saveDataB(o);
        });
        ExecutorService executorService = p.getEs();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        Long end = System.currentTimeMillis();
//        System.out.println("所有的子线程都结束了！耗时：" + (end - start));
        log.error("所有的子线程都结束了！耗时：" + (end - start));
        return "sucessB"+count;
    }




    @GetMapping("/insertB/{num}")
    public String insertData80(@PathVariable(value = "num") int num, @Param("batch") int batch) throws InterruptedException {
        ProjectDataListener p = new ProjectDataListener(testService);
        if(batch == 0){
            batch = 50;
        }
        List<DeviceData> deviceStatusList = new ArrayList<>();
        int count = num * 10000;
        for (int i = 0; i < count; i++) {
            DeviceData deviceStatus = new DeviceData();
//            String uid = UUID.randomUUID().toString().replaceAll("-", "");
//            deviceStatus.setId(uid);
            Date date = new Date();
            deviceStatus.setStartTime(date);
            deviceStatus.setEndTime(date);
            deviceStatus.setDeviceId("" + i);
            deviceStatus.setAttrCode("switch");
            deviceStatus.setAttrVal("on");
            deviceStatus.setCategory("11");
            deviceStatus.setGatewayMac("" + i);
            deviceStatusList.add(deviceStatus);
        }
        List<List<DeviceData>> data = Lists.partition(deviceStatusList,batch);
        log.error("开始插入"+num+"万数据！"+batch+"一批");
        Long start = System.currentTimeMillis();
        data.forEach(o->{
            p.saveDataB(o);
        });
        ExecutorService executorService = p.getEs();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        Long end = System.currentTimeMillis();
//        System.out.println("所有的子线程都结束了！耗时：" + (end - start));
        log.error("所有的子线程都结束了！耗时：" + (end - start));
        return "sucessB"+count;
    }


    @GetMapping("/test")
    public String test() {
        return "sucess123";
    }
}
