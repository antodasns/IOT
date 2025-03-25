package com.device.iot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.device.iot.model.DeviceCommand;
import com.device.iot.model.DeviceEvent;
import com.device.iot.model.DeviceResponse;

@Service
public class DeviceProducer {

    @Autowired
    private KafkaTemplate<String, DeviceEvent> eventKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, DeviceCommand> commandKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, DeviceResponse> responseKafkaTemplate;

    public void publishDeviceRegistered(String deviceId,String name) {
        DeviceEvent event = new DeviceEvent(deviceId, name);
        eventKafkaTemplate.send("thingwire.devices.events", event);
    }

    public void publishDeviceCommand(String deviceId, String command) {
        DeviceCommand deviceCommand = new DeviceCommand(deviceId, command);
        commandKafkaTemplate.send("thingwire.devices.commands", deviceCommand);
    }

    public void publishDeviceCommandResponse(String deviceId, String status) {
        DeviceResponse response = new DeviceResponse(deviceId, status);
        responseKafkaTemplate.send("thingwire.devices.responses", response);
    }
}
