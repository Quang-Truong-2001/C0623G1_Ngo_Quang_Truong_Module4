package com.example.mail.service;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("doantotnghiep19dl2@gmail.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
//        mailSender.send(message);
//        System.out.println("Mail Sent Success");


        MimeMessage message=mailSender.createMimeMessage();
        boolean multipart= true;
        try {
            MimeMessageHelper helper= new MimeMessageHelper(message,multipart);
            helper.setTo(toEmail);
            helper.setText(body);
            helper.setSubject(subject);
            helper.addAttachment("hoa",);
        } catch (MessagingException e) {
            System.out.println("loi");
        }
    }
}
