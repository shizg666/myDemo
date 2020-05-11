//package com.shizg.smartme.mqttdemo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//
///**
// * @ClassName Task
// * @Description: TODO
// * @Author shizg
// * @Date 2020/3/30
// * @Version V1.0
// **/
//@Component
//@Slf4j
//public class Task {
//
//    @Scheduled(cron = "0/10 * * * * ?")
//     public void sendMessage() throws IOException, URISyntaxException {
//        log.info("*****************开始调用");
//        URI uri = new URIBuilder("http://40.73.77.122:38084/smarthome_gateway/smarthome-gateway/synchronize/data").setParameter("mac", "0a 0b 0c 0d 0e 0a").build();
//         // 创建Httpclient对象,相当于打开了浏览器
//         CloseableHttpClient httpclient = HttpClients.createDefault();
//
//         // 创建HttpGet请求，相当于在浏览器输入地址
//         HttpGet httpGet = new HttpGet(uri);
//
//         CloseableHttpResponse response = null;
//         try {
//             // 执行请求，相当于敲完地址后按下回车。获取响应
//             response = httpclient.execute(httpGet);
//             // 判断返回状态是否为200
//             if (response.getStatusLine().getStatusCode() == 200) {
//                 // 解析响应，获取数据
//                 String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                 System.out.println(content);
//             }
//         } catch (ClientProtocolException e) {
//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             if (response != null) {
//                 // 关闭资源
//                 response.close();
//             }
//             // 关闭浏览器
//             httpclient.close();
//         }
//
//     }
//
//}
