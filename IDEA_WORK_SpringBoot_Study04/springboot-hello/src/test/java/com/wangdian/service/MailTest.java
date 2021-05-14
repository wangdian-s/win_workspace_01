package com.wangdian.service;


import com.wangdian.springboot.HelloSpringboot;
import com.wangdian.springboot.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HelloSpringboot.class})
public class MailTest {

    @Autowired
    MailService mailService;

    @Test
    public void sendMailTest(){
        mailService.sendMail(
                "728742519@qq.com",
                "Hello_JAVA_MailTest",
                "JAVA_Mail邮件测试成功！");
    }
}
