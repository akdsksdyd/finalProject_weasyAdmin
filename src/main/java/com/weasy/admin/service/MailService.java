package com.weasy.admin.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Service
@AllArgsConstructor
public class MailService {
	
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "kerri.shin@gmail.com";
	
	 public void pwresetMail(String userEmail, String birth) {
		 
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo(userEmail);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("비밀번호 초기화 완료");
	        message.setText("비밀번호가 회원님의 생년월일로 초기화되었습니다.");

	        mailSender.send(message);
	    }
	 
	 public void permissionMail(String userEmail) {
		 
		 	SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo(userEmail);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("가입승인 완료");
	        message.setText("회원님의 가입승인이 완료되었습니다.");

	        mailSender.send(message);
		 
		 
	 }
}
