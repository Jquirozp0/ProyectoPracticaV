package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Role;

import java.util.List;

public interface RoleService {

    public List<Role> listRoles();
    public Role saveRoles(Role role);

    public Role findRolebyId(Long id);
    public void  deleteRole(Long id);
}
