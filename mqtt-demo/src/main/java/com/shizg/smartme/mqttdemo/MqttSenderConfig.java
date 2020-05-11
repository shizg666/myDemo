//package com.shizg.smartme.mqttdemo;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
////@Configuration
////@IntegrationComponentScan
//public class MqttSenderConfig {
//
//    @Value("${mqtt.username}")
//    private String username;
//
//    @Value("${mqtt.password}")
//    private String password;
//
//    @Value("${mqtt.url}")
//    private String hostUrl;
//
//    @Value("${mqtt.clientid}")
//    private String clientId;
//
//    @Value("${mqtt.topic}")
//    private String defaultTopic;
//
//    @Value("${mqtt.timeout}")
//    private int completionTimeout ;   //连接超时
//
////    @Bean
////    public MqttConnectOptions getMqttConnectOptions(){
////        MqttConnectOptions mqttConnectOptions=new MqttConnectOptions();
////        mqttConnectOptions.setCleanSession(true);
////        mqttConnectOptions.setConnectionTimeout(10);
////        mqttConnectOptions.setKeepAliveInterval(90);
////        mqttConnectOptions.setAutomaticReconnect(true);
////        mqttConnectOptions.setUserName(username);
////        mqttConnectOptions.setPassword(password.toCharArray());
////        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
////        mqttConnectOptions.setKeepAliveInterval(2);
////        return mqttConnectOptions;
////    }
////    @Bean
////    public MqttPahoClientFactory mqttClientFactory() {
////        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
////        factory.setConnectionOptions(getMqttConnectOptions());
////        return factory;
////    }
////    @Bean
////    @ServiceActivator(inputChannel = "mqttOutboundChannel")
////    public MessageHandler mqttOutbound() {
////        MqttPahoMessageHandler messageHandler =  new MqttPahoMessageHandler(clientId, mqttClientFactory());
////        messageHandler.setAsync(true);
////        messageHandler.setDefaultTopic(defaultTopic);
////        return messageHandler;
////    }
////    @Bean
////    public MessageChannel mqttOutboundChannel() {
////        return new DirectChannel();
////    }
//}
//
