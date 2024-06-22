package com.careers.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careers.entity.User;
import com.careers.repository.UserRepository;

@Service
public class UserServiceImp implements UserServices{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SendEmailService emailService;

	@Override
	public void addUser(User user) {
		 user.setEnabled("false");
	        user.setToken((UUID.randomUUID()).toString());
	        userRepository.save(user);
	        emailService.sendActivationEmail(user);
		
	}
	public User activateUser(String token) {
        User user = userRepository.findByToken(token);
        if (user != null) {
            user.setEnabled("true");
            user.setToken(null);
            userRepository.save(user);
        }
        return user;
    }
       
    

}
