package com.careers.services;

import com.careers.entity.User;

public interface UserServices {
	public void addUser(User user);
    public User activateUser(String token);
}
