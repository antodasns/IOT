package com.device.iot.services;

import com.device.iot.entity.User;


public interface UserService {
	
	User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}
