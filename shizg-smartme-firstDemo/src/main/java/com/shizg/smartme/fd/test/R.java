package com.shizg.smartme.fd.test;

public class R implements Runnable {
    private static final Object LOCK = new Object();
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;
    /**
     * 线程数量
     */
    private int threadCount;
    /**
     * 打印的最大数值
     */
    private int maxInt;


    public R(int threadNo, int threadCount, int maxInt) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.maxInt = maxInt;
    }

    public R() {

    }


    @Override
    public void run() {
        while (true) {
            System.out.println("###################################################"+"thread" + threadNo + " : " + current);
            synchronized (LOCK) {
                // 判断是否轮到当前线程执行
                while (current % threadCount != threadNo) {
                    System.out.println("***********************************************************"+"thread" + threadNo + " : " + current);
                    if (current > maxInt) {
                        break;
                    }
                    try {
                        // 如果不是，则当前线程进入wait
                        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+"thread" + threadNo + " : " + current);
                        LOCK.wait();
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+"thread" + threadNo + " : " + current);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 最大值跳出循环
                if (current > maxInt) {
                    break;
                }
                System.out.println("thread" + threadNo + " : " + current);
                current++;
                // 唤醒其他wait线程
                LOCK.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        int threadCount = 2;
        int max = 10;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new R(i, threadCount, max)).start();
        }
    }

    public void run2() {
        int i = 1;
                while (true){
                    if(i<999999999){
                        i++;
                        System.out.println("22222222222222222222");
                    }else {
                        break;
                    }
        }

    }


}
