package com.device.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.device.iot.entity.IotDevices;
import com.device.iot.entity.IotDevices.Status;

import jakarta.transaction.Transactional;

@Repository
public interface IotRepository extends JpaRepository<IotDevices, String>{
	
	@Modifying
    @Transactional
    @Query("UPDATE IotDevices d SET d.status = :status WHERE d.id = :id")
    int updateDeviceStatus(@Param("id") String id, @Param("status") Status status);
	

}
