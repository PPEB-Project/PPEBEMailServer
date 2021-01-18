package com.erban.ppebtarget.email.http;


import com.erban.ppebtarget.email.mail.EMailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ppebtarget/email")
public class SendRegisterMail {
    private EMailManager mailManager = new EMailManager();
    @Autowired
    private JavaMailSender mailSender;
    @PostMapping(value = "/regist")
    public void SendRegistEMail(@RequestParam(value = "email",required = false) String email,
                                @RequestParam(value = "code",required = false) String code)
    {
//        mailManager.sendSimpleMail(email,"this is demo email","demo email");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ppeb_target@163.com");
        message.setTo("943186182@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}
