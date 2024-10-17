package com.ucentral.secmgmt.controller;

import com.ucentral.secmgmt.model.Management;
import com.ucentral.secmgmt.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"} )
@RestController
@RequestMapping(value = "/managements")
public class ManagementController {
    @Autowired
    private ManagementService managementService;

    @GetMapping("/index")
    public List<Management> listar() {
        return managementService.listManagements();

    }
    @PostMapping("/index")
    @ResponseStatus(HttpStatus.CREATED)
    public Management saveManagements(@RequestBody Management management) {
        return managementService.saveManagement(management);
    }
    @GetMapping("/index/{id}")
    public Management listManagements (@PathVariable Long id) {
        return managementService.findManagementbyId(id);
    }

    @PutMapping("/index/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Management actualizarManagements(@RequestBody Management management, @PathVariable Long id){
        Management managementActual = managementService.findManagementbyId(id);
        managementActual.setFechaHoraGestion(management.getFechaHoraGestion());
        managementActual.setAccionesRealizadas(management.getAccionesRealizadas());
        managementActual.setComentarios(management.getComentarios());
        managementActual.setUser(management.getUser());
        managementActual.getVulnerabilidad().setVulnerabilityState(management.getVulnerabilidad().getVulnerabilityState());
        managementActual.setImagenSoporte(management.getImagenSoporte());
        return managementService.saveManagement(managementActual);
    }
    @DeleteMapping("/index/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarManagements(@PathVariable Long id) { managementService.deleteManagement(id);}
}
