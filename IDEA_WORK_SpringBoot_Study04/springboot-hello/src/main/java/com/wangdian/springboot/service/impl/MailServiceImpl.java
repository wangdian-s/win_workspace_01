package com.wangdian.springboot.service.impl;

import com.wangdian.springboot.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {
    @Value("${mail.fromMail.addr}")
    private String from;
    // 登录邮件账号密码
    @Value("${mail.password}")
    private String password;
    // ssl授权密码
    @Value("${mail.password2}")
    private String password2;

    @Override
    public void sendMail(String to, String subject, String content) {
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.host", "smtp.qq.com");//域名地址
            prop.setProperty("mail.smtp.username", "974692952@qq.com");//邮件地址
            prop.setProperty("mail.smtp.password", password);//邮件密码
            prop.setProperty("mail.smtp.defaultEncoding", "UTF-8");//邮件编码
            prop.setProperty("mail.smtp.auth", "true");//
            // smtp.126.com 安全类型：SSL 端口号：465
            prop.setProperty("mail.smtp.port", "465");//发送邮件端口号
            prop.put("mail.smtp.ssl.enable", "true");//是否开启认证
            //建立Session连接授权认证
            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("974692952@qq.com", password2);
                }
            });
            //通过会话,得到一个邮件,用于发送
            MimeMessage mMessageHelper = new MimeMessage(session);
            // 发件人
            mMessageHelper.setFrom(new InternetAddress(from));
            // 设置收件人,to为收件人,
            mMessageHelper.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            //测试代码
            // 邮件主题
            mMessageHelper.setSubject(subject);
            // 邮件内容
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            content = "<html>\n" +
                    "<body>\n" +
                    " <h1>hello world ! 这是一封Html邮件!</h1>\n" +
                    " <h1> 这是第二行的邮件内容</h1>\n" +
                    "</body>\n" +
                    "</html>";
            // 设置HTML内容
            html.setContent(content, "text/html; charset=utf-8");
            // 邮件html正文内容
            mainPart.addBodyPart(html);
            // 附件的地址
            String filePath = "D:\\data.txt";
            // 附件的名字
            String fileName = "data.txt";
            //存放附件或摘要
            if (fileName != null) {
            //添加附件
                File usFile = new File(filePath);
            // 添加附件的内容
                BodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(usFile);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
            //MimeUtility.encodeWord可以避免文件名乱码
                attachmentBodyPart.setFileName(MimeUtility.encodeWord(usFile.getName()));
            // 设置为邮件附件内容
                mainPart.addBodyPart(attachmentBodyPart);
            }
            //设置为邮件回复内容
            mMessageHelper.setContent(mainPart);
            Transport.send(mMessageHelper);
            System.out.println("简单邮件已经发送。");
        } catch (Exception e) {
            System.out.println("发送简单邮件时发生异常！");
        }
    }
}
