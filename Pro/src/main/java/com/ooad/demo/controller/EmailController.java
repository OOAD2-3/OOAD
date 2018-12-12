package com.ooad.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ooad.demo.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WinstonDeng
 * @Description: 邮件发送
 * @Date: Created in 12:58 2018/12/10
 * @Modified by:
 */
@RestController
public class EmailController {
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @RequestMapping("/sendemail")
    public String sendEmail() throws JsonProcessingException {
        boolean isSend = EmailUtils.sendEmail("ooadEmail邮件测试", new String[]{"842237857@qq.com"}, null, "<h3><a>6不6，舒服了</a></h3>", null);
        return "发送邮件:" + isSend;
    }

}
