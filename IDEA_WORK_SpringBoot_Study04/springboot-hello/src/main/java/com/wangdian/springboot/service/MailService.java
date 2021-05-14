package com.wangdian.springboot.service;

public interface MailService {
    void sendMail(String to, String subject, String content);
}
