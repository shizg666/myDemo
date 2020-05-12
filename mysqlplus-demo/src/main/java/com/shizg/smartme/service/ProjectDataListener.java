package com.shizg.smartme.service;

import com.shizg.smartme.domin.DeviceData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 工程批量导入监听器
 */
// 有个很重要的点 ProjectDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Component
@Slf4j
public class ProjectDataListener {

    /**
     * 线程池维护线程的最大数量
     */
    private static final int MAXIMUMPOOLSIZE = 50;
    /**
     * 线程池维护线程的最少数量
     */
    private static final int COREPOOLSIZE = 50;

    /**
     * 线程池所使用的缓冲队列
     */
    private static final int WORKQUEUE = 60000;
    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final long KEEPALIVETIME = 60L;

    private ExecutorService es;


    private TestService testService;


    public ExecutorService getEs() {
        return es;
    }

    public ProjectDataListener(TestService testService) {
this.testService = testService;
        es = new ThreadPoolExecutor(COREPOOLSIZE, MAXIMUMPOOLSIZE,
                KEEPALIVETIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue(WORKQUEUE), new ThreadPoolExecutor.CallerRunsPolicy());
    }








    /**
     * 存储数据库
     */
    public void saveData(DeviceData data) {
        es.submit(new ResolveTask(data));
    }
    public void saveDataB(List<DeviceData> data) {
        es.submit(new ResolveTask2(data));
    }

    private class ResolveTask implements Runnable {

        private DeviceData data;

        private ResolveTask(DeviceData data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
//                testService.save(data);
            }catch (Exception e){
                System.out.println("**************** id :"+data.getId()+"---- "+ e.getMessage());
            }

        }
    }


    private class ResolveTask2 implements Runnable {

        private List<DeviceData> data;

        private ResolveTask2(List<DeviceData> data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
//                testService.saveBatch(data);
            }catch (Exception e){
                System.out.println("**************** id :"+"---- "+ e.getMessage());
            }

        }
    }


}