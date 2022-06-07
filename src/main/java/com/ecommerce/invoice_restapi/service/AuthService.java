package com.ecommerce.invoice_restapi.service;


import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.JWTTokenModel;


public interface AuthService {
    public JWTTokenModel authenticate(String username,String password);
    public Integer unauthneticate();
    public User register(User user);
    public User verify(String code);
}
