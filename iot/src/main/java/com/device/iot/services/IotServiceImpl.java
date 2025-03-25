package com.device.iot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.device.iot.entity.IotDevices;
import com.device.iot.entity.IotDevices.Status;
import com.device.iot.repository.IotRepository;


@Service
public class IotServiceImpl implements IotService{
	
	@Autowired
	IotRepository iotRepository;

	@Override
	public void registerDevice(IotDevices iotDevice) {
		
		iotRepository.save(iotDevice);
		
	}

	@Override
	public IotDevices getDevice(String id) {
		return iotRepository.findById(id).get();
	}

	@Override
	public void updateDevice(String id,IotDevices iotDevice) {
		
		iotDevice.setId(id);
		iotRepository.save(iotDevice);
	}

	@Override
	public void deleteDevice(String id) {
		iotRepository.deleteById(id);
		
	}

	@Override
	public void updateStatus(String id, String status) {
		
		iotRepository.updateDeviceStatus(id,Status.valueOf(status));
		
	}
	
	@Override
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
