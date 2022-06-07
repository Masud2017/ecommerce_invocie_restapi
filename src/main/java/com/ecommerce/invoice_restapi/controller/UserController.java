package com.ecommerce.invoice_restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.ProfileModel;
import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.UserAddress;
import com.ecommerce.invoice_restapi.service.UserService;

@RestController
@RequestMapping(method = RequestMethod.GET,value = "/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<ProfileModel> me() {
        return ResponseEntity.ok(this.userService.me());
    }

    @GetMapping("/adduseraddress")
    public ResponseEntity<User> addUserAddress(@RequestBody UserAddress userAddress) {
        return ResponseEntity.ok(this.userService.addUserAddress(userAddress));
    }
    
}
