package com.ucentral.secmgmt.controller;

import com.ucentral.secmgmt.model.Role;
import com.ucentral.secmgmt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"} )
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public List<Role> listar() {
        return roleService.listRoles();

    }
    @PostMapping("/index")
    @ResponseStatus(HttpStatus.CREATED)
    public Role saveRoles(@RequestBody Role role) {
        return roleService.saveRoles(role);
    }
    @GetMapping("/index/{id}")
    public Role listRoles (@PathVariable Long id) {
        return roleService.findRolebyId(id);
    }

    @PutMapping("/index/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Role actualizarRoles(@RequestBody Role role, @PathVariable Long id){
        Role roleActual = roleService.findRolebyId(id);
        roleActual.setName(role.getName());
        return roleService.saveRoles(roleActual);
    }
    @DeleteMapping("/index/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarRoles(@PathVariable Long id) { roleService.deleteRole(id);}

}
