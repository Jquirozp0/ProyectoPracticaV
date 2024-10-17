package com.ucentral.secmgmt.repository;

import com.ucentral.secmgmt.model.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Management,Long> {
}
