package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findUserLoginByUserId(Long id);

}
