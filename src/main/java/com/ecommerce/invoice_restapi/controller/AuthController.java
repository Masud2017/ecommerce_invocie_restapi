package com.ecommerce.invoice_restapi.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.AuthRequest;
import com.ecommerce.invoice_restapi.model.BlackListedJWTTokenModel;
import com.ecommerce.invoice_restapi.model.JWTTokenModel;
import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.VerificationCodeModel;
import com.ecommerce.invoice_restapi.service.AuthService;
import com.ecommerce.invoice_restapi.util.BLackListedJWTTokenUtil;
import com.ecommerce.invoice_restapi.dao.BlackListedJWTTokenRepository;

@RestController
@RequestMapping(method = RequestMethod.GET,value = "/api/v1")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;
    @Autowired
    private BlackListedJWTTokenRepository blackListedJWTTokenRepository;


    
    @GetMapping("/")
    public String hello() {
        return "Hello world this is an authenticated access";
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JWTTokenModel> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(this.authService.authenticate(authRequest.getUsername(), authRequest.getPassword()));
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        logger.info(user.getPassword());
        return this.authService.register(user);
    }

    @GetMapping("/verify")
    public User verify(@RequestParam("code") String code) {
        return this.authService.verify(code);
    }

    @GetMapping("/forgetpassword")
    public ResponseEntity<VerificationCodeModel> forgetPassword(@RequestParam String username) {
        logger.info(username);
        return ResponseEntity.ok(this.authService.forgetPassword(username));
    }

    @GetMapping("/verifyforgetpassword")
    public ResponseEntity<User> verifyForgetPassword(@RequestParam String code, @RequestParam String password) {
        return ResponseEntity.ok(this.authService.verifyForgetPassword(code,password));
    }

    @GetMapping("/test")
    public List<BlackListedJWTTokenModel> test() {
        BlackListedJWTTokenModel model = new BlackListedJWTTokenModel();
        model.setUsername("msmasud578@gmail.com");
        model.setJwtToken("nothinto show here");
        model.setValid(true);
        this.blackListedJWTTokenRepository.deleteAll();

        // this.blackListedJWTTokenRepository.save(model);

        Iterable<BlackListedJWTTokenModel> iter = this.blackListedJWTTokenRepository.findAll();
        List<BlackListedJWTTokenModel> list = new ArrayList<BlackListedJWTTokenModel>();
        Iterator itter =  iter.iterator();

        itter.forEachRemaining(t -> list.add((BlackListedJWTTokenModel)t));

        // logger.info(this.blackListedJWTTokenRepository.findByUsername("msmasud578@gmail.com").getJwtToken());
        logger.info(this.blackListedJWTTokenRepository.existsByUsername("msmasud578@gmail.com") ? "hello everythis is true" : "everything is false");

        // BLackListedJWTTokenUtil util = new BLackListedJWTTokenUtil();
        // util.saveTheGeneratedToken();

        

        return list;
    }


}
