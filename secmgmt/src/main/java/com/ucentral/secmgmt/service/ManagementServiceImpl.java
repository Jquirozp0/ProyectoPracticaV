package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.Management;
import com.ucentral.secmgmt.repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagementServiceImpl  implements ManagementService {
    @Autowired
    private ManagementRepository managementRepository;
    @Override
    public List<Management> listManagements() {
        return managementRepository.findAll();
    }

    @Override
    public Management saveManagement(Management management) {
        return managementRepository.save(management);
    }

    @Override
    public Management findManagementbyId(Long id) {
        return managementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteManagement(Long id) {
        managementRepository.deleteById(id);
    }

}
