package com.careers.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.careers.entity.User;
import com.careers.services.UserServices;



@Controller
public class MapController{
	@Autowired
	UserServices userService;
	
	@GetMapping("/careers")
	 public String careers()
	 {
		 return "careers";
	 }
	@PostMapping("/signup")
	@ResponseBody
	public Map<String, String> addUser(@RequestBody User user) {
	    userService.addUser(user);
	    Map<String, String> response = new HashMap<>();
	    response.put("success", "true");
	    response.put("message", "Verification email sent");
	    return response;
	}
	 @GetMapping("/activate")
	    public String activateUser(@RequestParam String token, Model model) {
	        User user = userService.activateUser(token);
	        
	        if (user != null) {
	            model.addAttribute("user", user);
	            return "profile";
	        } else {
	            return "redirect:/activation-failed";
	        }
	    }


}
