package com.device.iot.model;

public class DeviceCommand {
    private String deviceId;
    private String command;

    public DeviceCommand() {}

    public DeviceCommand(String deviceId, String command) {
        this.deviceId = deviceId;
        this.command = command;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getCommand() {
        return command;
    }
}

