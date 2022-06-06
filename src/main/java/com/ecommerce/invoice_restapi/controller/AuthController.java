package com.ecommerce.invoice_restapi.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.AuthRequest;

@RestController
@RequestMapping(method = RequestMethod.GET,value = "/api/v1")
public class AuthController {
    @PostMapping("/authenticate")
    //ModelAttribute for accepting form data
    public String authenticate(@ModelAttribute AuthRequest authRequest) {
        return "He3llo world gre;l;eting"+authRequest.getUsername()+authRequest.getPassword();
    }
    
}
