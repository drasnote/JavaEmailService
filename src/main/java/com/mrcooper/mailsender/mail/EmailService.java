package com.mrcooper.mailsender.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String mailBody) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(mailBody);
            emailSender.send(mailMessage);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    public void sendHtmlMessage(String to, String subject, Map<String, String> mailMappings) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Hello World!</h3>";
            mimeMessage.setContent(htmlMsg, "text/html");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
