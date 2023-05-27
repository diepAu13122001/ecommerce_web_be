package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.UserLogin;

public interface IUserLoginService {
    void save(UserLogin userLogin);
    UserLogin findUserLoginByUserId(Long id);
}
