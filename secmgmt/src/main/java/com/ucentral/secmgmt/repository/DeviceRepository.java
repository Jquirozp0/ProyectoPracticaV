package com.ucentral.secmgmt.repository;

import com.ucentral.secmgmt.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d WHERE d.ip_address = :ipAddress")
    Device findByIpAddress(@Param("ipAddress") String ipAddress);
}
