package com.ecommerce.invoice_restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.invoice_restapi.dao.UserRepository;
import com.ecommerce.invoice_restapi.model.User;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDetailsService userDetailsUservice;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UsernamePasswordAuthenticationToken authenticate(String username, String password) {
        
        return null;
    }
    

    @Override
    public Integer unauthneticate() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public com.ecommerce.invoice_restapi.model.User register(User user) {
        
        User ifAvail = this.userRepository.findByEmail(user.getEmail());
        if (ifAvail != null) {
            return ifAvail;
        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword())); // encoding the password with bcrypt algorithm which is already declared in the bean
        this.userRepository.save(user);
        return user;
    }


    @Override
    public boolean verify(String code) {
        // User user = this.userRepository.findByVerificationCode(code);
        // if (user != null) {
        //     return ;
        // }
        return false;
    }
    
}
