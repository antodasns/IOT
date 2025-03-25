package com.device.iot.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.device.iot.entity.IotDevices;

public interface IotService {

	void registerDevice(IotDevices iotDevice);

	IotDevices getDevice(String id);

	void updateDevice(String id, IotDevices iotDevice);

	void deleteDevice(String id);

	void updateStatus(String id,String status);
	
	BCryptPasswordEncoder bCryptPasswordEncoder();
	

}
