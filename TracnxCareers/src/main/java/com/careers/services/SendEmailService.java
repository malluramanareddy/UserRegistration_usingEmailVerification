package com.careers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.careers.entity.User;

import jakarta.mail.internet.MimeMessage;


@Service
public class SendEmailService {
	
	
	@Autowired
	private JavaMailSender mailSender;
	@Value("$(spring.mail.username)")
		private String fromAddress;
		
		
//		public void sendMail()
//		{
//			SimpleMailMessage mailMessage=new SimpleMailMessage();
//			mailMessage.setFrom("rajunerenika@gmail.com");
//			mailMessage.setTo("nernikaraju1993@gmail.com");
//			mailMessage.setText("hii body");
//			mailMessage.setSubject("subject");
//			mailSender.send(mailMessage);
//		}
		
		public void sendActivationEmail(User user) {
	        String toAddress = user.getEmail();
	       
	        String subject = "Please Activate Your Account";
	        String content = "Dear " + user.getFullName() + ",<br>"
	                + "Please click the link below to activate your account:<br>"
	                + "<a href=\"http://localhost:8080/activate?token=" + user.getToken()+ "\">Activate Now</a>";

	      

	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);

	            helper.setFrom(fromAddress);
	            helper.setTo(toAddress);
	            helper.setSubject(subject);
	            helper.setText(content, true);

	            mailSender.send(message);
	        } catch (Exception e) {
	          
	            e.printStackTrace();
	        }


		

	}

}
