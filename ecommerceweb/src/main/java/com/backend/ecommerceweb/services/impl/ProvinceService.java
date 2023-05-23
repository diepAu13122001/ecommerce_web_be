package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

@org.springframework.stereotype.Service
public class ProvinceService extends ABaseService implements IUserLoginService {
    @Override
    public void save(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
    }

    @Override
    public UserLogin findUserLoginByUserId(Long id) {
        return userLoginRepository.findUserLoginByUserId(id);
    }
}
