package com.careers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careers.services.SendEmailService;


@RestController
public class EmailController {
	
	@Autowired
	private SendEmailService emailService;
	
	
//	
//	@GetMapping("/sendmail")
//	public String sendMail()
//	{
//		//emailService.sendMail();
//		emailService.sendActivationEmail();
//		return "sent";
//	}
}
