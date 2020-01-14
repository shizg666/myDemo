package com.shizg.smartme.fd.controller;


import com.shizg.smartme.fd.factory.PriceStrategyFactory;
import com.shizg.smartme.fd.service.PriceStrategy;
import com.shizg.smartme.fd.utils.MailUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/mail/")
public class MailController {

    @Autowired
    private MailUtils mailUtils;

    @ApiOperation(value = "邮件测试", notes = "", consumes = "application/json")
    @GetMapping(value = "/smile-send")
    public void test() throws MessagingException {
        mailUtils.sendSimpleEmail();
        mailUtils.mimeEmail();
        mailUtils.htmlEmail();
        mailUtils.contextLoads();
    }
}
