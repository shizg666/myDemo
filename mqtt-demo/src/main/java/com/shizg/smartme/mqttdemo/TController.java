//package com.shizg.smartme.mqttdemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @ClassName TController
// * @Description: TODO
// * @Author shizg
// * @Date 2020/3/27
// * @Version V1.0
// **/
//@RestController
//@RequestMapping("/t")
//public class TController {
//    @Autowired
//    private MqttPushClient mqttPushClient;
//    @GetMapping("/t1")
//    public String push(){
//        mqttPushClient.publish("/up/data2","123");
//        return "1";
//    }
//    @GetMapping("/t2")
//    public String push2(@RequestParam(value = "topic") String topic){
//        mqttPushClient.publish(topic,"123");
//        return "2"+topic;
//    }
//}
