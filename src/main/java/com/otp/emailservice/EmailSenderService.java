package com.otp.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendOtpMail(String toEmail,String subject,int text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("1803167.cse.cec@cgc.edu.in");
		message.setTo(toEmail);
		message.setText(Integer.toString(text));
		message.setSubject(subject);
		mailSender.send(message);
	}
	
	public void sendSuccessMail(String toEmail,String subject,String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("1803167.cse.cec@cgc.edu.in");
		message.setTo(toEmail);
		message.setText(text);
		message.setSubject(subject);
		mailSender.send(message);
	}



}
