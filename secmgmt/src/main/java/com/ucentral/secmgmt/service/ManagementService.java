package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Management;

import java.util.List;

public interface ManagementService {

    public List<Management> listManagements();
    public Management saveManagement(Management management);
    public Management findManagementbyId(Long id);
    public void  deleteManagement(Long id);
}
