package com.shizg.smartme;

public class Test {
    public static void main(String args[]) throws InterruptedException {
//        while (true){
//            Thread.sleep(1000L);
//            cc ++;
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!"+cc);
//            int finalCc = cc;
//            if (cc <3){
//                new Thread(()->{
//                    System.out.println(finalCc +"---22222222222----"+Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(6000L);
//                        System.out.println(finalCc +"---谁玩----"+Thread.currentThread().getName());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//            }
//            System.out.println("###############################"+cc);
//        }
    }

    public static  void f(int cc){
        cc = 100;
        System.out.println("cc1"+cc);
    }
}
