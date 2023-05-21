package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserRole;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserRoleService;
import org.springframework.stereotype.Service;


@Service
public class UserRoleService extends ABaseService implements IUserRoleService {
    @Override
    public UserRole createUserRole(User user, String roleId) {
//        Role role = roleRepository.findById(roleId).get();
//        if (role != null) {
//            UserRole userRole = new UserRole();
//            userRole.setUserId(user.getId());
//            userRole.setRole(role);            UserRole f = userRoleRepository.save(userRole);
//            return f;
//
//        }
        return null;
    }
}
