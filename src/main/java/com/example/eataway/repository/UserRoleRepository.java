package com.example.eataway.repository;

import com.example.eataway.model.entity.UserRole;
import com.example.eataway.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("SELECT ur FROM UserRole ur WHERE ur.userRole = :userRole")
    Optional<UserRole> findByUserRoleLike(@Param("userRole") UserRoleEnum userRole);
}
