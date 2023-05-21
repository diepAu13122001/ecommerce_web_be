package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);

    User findByEmail(String username);

    User findById(Long userId);

    List<User> findUsersByIdIn(List<Long> ids);

}
