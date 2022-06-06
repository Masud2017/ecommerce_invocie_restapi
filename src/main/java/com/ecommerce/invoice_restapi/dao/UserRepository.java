package com.ecommerce.invoice_restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.invoice_restapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public User findByEmail(String username);
    // public User findByVerificationCode(String code);
}
