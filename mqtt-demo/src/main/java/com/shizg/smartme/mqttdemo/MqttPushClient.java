package com.shizg.smartme.mqttdemo;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 创建一个MQTT客户端
 * @author wunaozai
 * @date 2018-08-22
 */
@Slf4j
@Component
public class MqttPushClient {




//    @Resource
//    private MqttSenderConfig config;

    private MqttClient client;
    private static volatile MqttPushClient mqttClient = null;
    private static volatile boolean asd = true;


    @PostConstruct
    public void init() {
        connect();
    }

//    public static MqttPushClient getInstance() {
//        if(mqttClient == null) {
//            synchronized (MqttPushClient.class) {
//                if(mqttClient == null) {
//                    mqttClient = new MqttPushClient();
//                }
//            }
//        }
//        return mqttClient;
//    }

    private MqttPushClient() {
//                connect();  log.info("Connect MQTT: " + this);

    }

    private void connect() {
        try {
            String clientID = UUID.randomUUID().toString();
            client = new MqttClient("tcp://40.73.77.122:1883", "6677", new MemoryPersistence());
            MqttConnectOptions option = new MqttConnectOptions();
            option.setCleanSession(true);
//            option.setUserName("dashboard");
            option.setConnectionTimeout(20);
            option.setKeepAliveInterval(10);
            option.setAutomaticReconnect(true);
            try {
                client.setCallback(new MqttPushCallback());
                client.connect(option);
                if (asd){
                    client.subscribe("$queue/test/share");
                    client.subscribe("$share/test/group/share");
                    client.subscribe("/test/tt");
                    log.info("Connect MQTT:********************************************************************************************* "+asd );
                }
                log.info("Connect MQTT:********************************************************************************************* "+asd );
         asd = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 发布主题，用于通知<br>
     * 默认qos为1 非持久化
     * @param topic
     * @param data
     */
    public void publish(String topic, String data) {
        publish(topic, data, 1, false);
    }
    /**
     * 发布
     * @param topic
     * @param data
     * @param qos
     * @param retained
     */
    public void publish(String topic, String data, int qos, boolean retained) {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(data.getBytes());
        MqttTopic mqttTopic = client.getTopic(topic);
        if(null == mqttTopic) {
            log.error("Topic Not Exist");
        }
        MqttDeliveryToken token;
        try {
            token = mqttTopic.publish(message);
            token.waitForCompletion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 订阅某个主题 qos默认为1
     * @param topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 1);
    }
    /**
     * 订阅某个主题
     * @param topic
     * @param qos
     */
    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, qos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
