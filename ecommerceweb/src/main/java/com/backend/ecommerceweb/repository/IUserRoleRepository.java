package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, String> {
    List<UserRole> findUserRolesByRoleId(String roleId);

}
