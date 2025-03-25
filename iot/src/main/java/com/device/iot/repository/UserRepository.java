package com.device.iot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.device.iot.entity.User;


public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findByUsername(String name);

}
