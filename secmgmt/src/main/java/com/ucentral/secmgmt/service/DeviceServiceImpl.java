package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Device;
import com.ucentral.secmgmt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public List<Device> listDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device saveDevices(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device findDevicebyId(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public Device findDeviceByIpAddress(String ipAddress) {
        return deviceRepository.findByIpAddress(ipAddress);
    }

}
