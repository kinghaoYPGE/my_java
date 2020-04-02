package com.springboot.demo.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MailServiceTest {

    @Autowired
    MailService mailService;

    private String to = "kinghao1020437855@163.com";
    private String subject = "SpringBoot Email Test";
    private String content = "This is SpringBoot Email Test, Do not reply";

    @Test
    void sendSimpleEmail() {
        mailService.sendSimpleEmail(to, subject, content);
    }

    @Test
    void sendInlineResourceMail() {
        String imagePath = "C:\\Users\\kinghao\\Pictures\\Saved Pictures\\wallhaven-163377.jpg";
        String rscId = "img110";
        String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
        try {
            mailService.sendInlineResourceMail(to, subject, content, imagePath, rscId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void sendHtmlMail() {
        String content = "<html><head></head><body><h3>SpringBoot Test</h3></body></html>";
        try {
            mailService.sendHtmlMail(to, subject, content);
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }

    @Test
    void sendAttachmentsMail() {
        String imagePath = "C:\\Users\\kinghao\\Pictures\\Saved Pictures\\wallhaven-727431.jpg";
        try {
            mailService.sendAttachmentsMail(to, subject, content, imagePath);
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }

    @Test
    void sendTemplateMail() {
        Map<String, Object> params = new HashMap<>();
        params.put("username", "SpringBootTest");

        try {
            mailService.sendTemplateMail(to, "测试Springboot发送模版邮件", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}