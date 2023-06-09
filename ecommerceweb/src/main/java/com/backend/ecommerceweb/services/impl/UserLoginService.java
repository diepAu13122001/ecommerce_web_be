package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService extends ABaseService implements IUserLoginService {
    @Override
    public void save(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
    }

    @Override
    public UserLogin findUserLoginByUserId(Long id) {
        return userLoginRepository.findUserLoginByUserId(id);
    }
}
