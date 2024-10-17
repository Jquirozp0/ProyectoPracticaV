package com.ucentral.secmgmt.controller;

import com.ucentral.secmgmt.model.Device;
import com.ucentral.secmgmt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"} )
@RestController
@RequestMapping(value = "/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/index")
    public List<Device> listar() {
        return deviceService.listDevices();

    }
    @PostMapping("/index")
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevices(@RequestBody Device device) {
        return deviceService.saveDevices(device);
    }
    @GetMapping("/index/{id}")
    public Device listDevice (@PathVariable Long id) {
        return deviceService.findDevicebyId(id);
    }

    @PutMapping("/index/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Device actualizarDevice(@RequestBody Device device, @PathVariable Long id){
        Device deviceActual = deviceService.findDevicebyId(id);
        deviceActual.setName(device.getName());
        deviceActual.setIp_address(device.getIp_address());
        deviceActual.setDescription(device.getDescription());
        return deviceService.saveDevices(deviceActual);
    }
    @DeleteMapping("/index/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarDevice(@PathVariable Long id) { deviceService.deleteDevice(id);}
}
