package com.backend.ecommerceweb.services;


import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserRole;

public interface IUserRoleService {
    UserRole createUserRole(User user, String roleId);
}
