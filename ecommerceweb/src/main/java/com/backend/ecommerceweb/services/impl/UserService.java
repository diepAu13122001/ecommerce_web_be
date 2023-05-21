package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ABaseService implements IUserService {
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    @Override
    public User findById(Long userId) {
        Optional<User> u = userRepository.findById(userId);
        return u.isPresent() == false ? null : u.get();
    }

    @Override
    public List<User> findUsersByIdIn(List<Long> ids) {
        return userRepository.findUsersByIdIn(ids);
    }
}
