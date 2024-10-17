    package com.ucentral.secmgmt.repository;

    import com.ucentral.secmgmt.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
        @Query("SELECT r.id FROM User u JOIN u.roles r WHERE u.id = :userId")
        Set<Long> findRoleIdsByUserId(@Param("userId") Long userId);
        Boolean existsByUsername(String username);

        
    }
