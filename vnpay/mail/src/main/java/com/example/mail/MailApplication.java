package com.example.mail;

import com.example.mail.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sedEmail(){
		senderService.sendEmail("quangtruong2112001@gmail.com", "Test thu", "This is Subject");
	}
}
