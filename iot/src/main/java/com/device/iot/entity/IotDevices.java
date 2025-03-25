package com.device.iot.entity;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class IotDevices {
	
	@Id
	private String id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "last_seen", nullable = false)
    private Timestamp lastSeen;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")  
    private Map<String, Object> metadata;

    public enum Status {
        ONLINE, OFFLINE, ERROR
    }

}
