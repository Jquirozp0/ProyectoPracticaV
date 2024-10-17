package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Role;
import com.ucentral.secmgmt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveRoles(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRolebyId(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
