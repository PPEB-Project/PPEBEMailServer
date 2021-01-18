package com.erban.ppebtarget.email.mail;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EMailManager {
    @Autowired
    private JavaMailSender mailSender;
//    public EMailManager()
//    {
//        this.mailSender = new JavaMailSenderImpl();
//    }
    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content, String... cc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        if (ArrayUtil.isNotEmpty(cc)) {
            message.setCc(cc);
        }
        mailSender.send(message);
    }
}
