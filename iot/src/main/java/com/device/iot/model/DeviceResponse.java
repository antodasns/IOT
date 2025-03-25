package com.device.iot.model;

public class DeviceResponse {
    private String deviceId;
    private String status;  // e.g., "success", "failed"

    public DeviceResponse() {}

    public DeviceResponse(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getStatus() {
        return status;
    }
}
