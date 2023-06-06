package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserCart;
import com.backend.ecommerceweb.entities.Ward;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserCartService;
import com.backend.ecommerceweb.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCartService extends ABaseService implements IUserCartService {
    public List<UserCart> findByProductAmount(int amount) {
        return userCartRepository.findByProductAmount(amount);
    }

    public List<UserCart> findByGiftId(Long id) {
        return userCartRepository.findByGiftId(id);
    }

    public UserCart findByUserId(Long userId) {
        return userCartRepository.findByUserId(userId);
    }

    @Override
    public List<UserCart> findAll() {
        return userCartRepository.findAll();
    }

    @Override
    public UserCart findById(Long id) {
        Optional<UserCart> u = userCartRepository.findById(id);
        return u.isPresent() == false ? null : u.get();
    }

    @Override
    public UserCart createUserCart(UserCart userCart) {
        return userCartRepository.save(userCart);
    }

    @Override
    public void delete(Long id) {
        userCartRepository.deleteById(id);
    }
}
