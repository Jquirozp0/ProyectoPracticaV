package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Device;

import java.util.List;

public interface DeviceService {


    public List<Device> listDevices();
    public Device saveDevices(Device device);
    public Device findDevicebyId(Long id);
    public void  deleteDevice(Long id);
    public Device findDeviceByIpAddress(String ipAddress);
}
