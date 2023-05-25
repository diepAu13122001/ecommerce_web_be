package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserCartRepository extends JpaRepository<UserCart, Long> {
    UserCart findByUser(Long userId);
}
