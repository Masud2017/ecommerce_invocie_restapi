package com.ecommerce.invoice_restapi.service;


import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.VerificationCodeModel;
import com.ecommerce.invoice_restapi.model.JWTTokenModel;


public interface AuthService {
    public JWTTokenModel authenticate(String username,String password);
    public User register(User user);
    public User verify(String code);
    public VerificationCodeModel forgetPassword(String username);
    public User verifyForgetPassword(String code,String newPassword);
}
