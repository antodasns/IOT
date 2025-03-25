package com.device.iot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.device.iot.model.DeviceCommand;
import com.device.iot.model.DeviceEvent;
import com.device.iot.model.DeviceResponse;
import com.device.iot.services.IotService;

@Component
public class DeviceConsumer {
	
	@Autowired
	IotService iotService;

    @KafkaListener(topics = "thingwire.devices.events", groupId = "device-group")
    public void handleDeviceEvents(DeviceEvent event) {
        System.out.println("Device Added: " + event.getDeviceName() + " for Device ID: " + event.getDeviceId());
    }

    @KafkaListener(topics = "thingwire.devices.commands", groupId = "device-group")
    public void handleDeviceCommands(DeviceCommand command) {
        System.out.println("Received Command: " + command.getCommand() + " for Device ID: " + command.getDeviceId());
    }

    @KafkaListener(topics = "thingwire.devices.responses", groupId = "device-group")
    public void handleDeviceResponses(DeviceResponse response) {
    	
    	iotService.updateStatus(response.getDeviceId(), response.getStatus());
        
    }
}

