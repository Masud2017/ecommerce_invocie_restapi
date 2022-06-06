package com.ecommerce.invoice_restapi.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.ecommerce.invoice_restapi.model.User;

public interface AuthService {
    public UsernamePasswordAuthenticationToken authenticate(String username,String password);
    public Integer unauthneticate();
    public User register(User user);
    public boolean verify(String code);
}
