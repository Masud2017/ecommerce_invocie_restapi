package com.ecommerce.invoice_restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.AuthRequest;
import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.service.AuthService;

@RestController
@RequestMapping(method = RequestMethod.GET,value = "/api/v1")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    //ModelAttribute for accepting form data
    public String authenticate(@ModelAttribute AuthRequest authRequest) {
        return "He3llo world gre;l;eting"+authRequest.getUsername()+authRequest.getPassword();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        logger.info(user.getPassword());
        return this.authService.register(user);
    }

    @GetMapping("/verify")
    public void verify(@RequestParam String code) {

    }
    
}
