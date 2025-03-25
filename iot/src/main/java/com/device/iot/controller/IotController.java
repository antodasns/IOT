package com.device.iot.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.device.iot.entity.IotDevices;
import com.device.iot.entity.User;
import com.device.iot.kafka.DeviceProducer;
import com.device.iot.services.IotService;
import com.device.iot.services.UserService;

@RestController
public class IotController {
	
	@Autowired
	IotService iotService;
	
	@Autowired
    private DeviceProducer deviceProducer;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/devices")
	public ResponseEntity<Map<String, String> > registerDevice(@RequestBody IotDevices iotDevice) { 
		
		iotDevice.setId(UUID.randomUUID().toString());
		iotService.registerDevice(iotDevice); 
		deviceProducer.publishDeviceRegistered(iotDevice.getId(),iotDevice.getName());
		
		Map<String, String> deviceId=new HashMap<>();
		
		deviceId.put("DeviceId", iotDevice.getId());
		
		return new ResponseEntity<>(deviceId,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/devices/{id}") 
	public IotDevices getDevice(@PathVariable("id") String id) {
		return iotService.getDevice(id);
	}
	
	@PutMapping("/devices/{id}") 
	public void updateDevice(@RequestBody IotDevices iotDevice,@PathVariable("id") String id) {
		 iotService.updateDevice(id,iotDevice);
	}
	
	@DeleteMapping("/devices/{id}") 
	public void deleteDevice(@PathVariable("id") String id) {
		 iotService.deleteDevice(id);
	}

	@PostMapping("/devices/{id}/send-command")
	public void sendCommand(@PathVariable("id") String id) { 
		deviceProducer.publishDeviceCommand(id,"ONLINE");
	}
	
	@PostMapping("/devices/{id}/{status}/send-command-status")
	public void sendCommandStatus(@PathVariable("id") String id,
			@PathVariable("status") String status) { 
		
		deviceProducer.publishDeviceCommandResponse(id,status);
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
