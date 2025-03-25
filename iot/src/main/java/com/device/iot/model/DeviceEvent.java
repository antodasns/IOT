package com.device.iot.model;

public class DeviceEvent {
    private String deviceId;
    private String deviceName;

    public DeviceEvent() {}

    public DeviceEvent(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }
}
