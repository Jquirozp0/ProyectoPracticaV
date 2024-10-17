package com.ucentral.secmgmt.repository;

import com.ucentral.secmgmt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName (String name);
    Optional<Role> findById (Long id);

}
