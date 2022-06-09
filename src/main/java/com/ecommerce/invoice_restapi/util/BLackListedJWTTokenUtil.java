package com.ecommerce.invoice_restapi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.invoice_restapi.dao.BlackListedJWTTokenRepository;
import com.ecommerce.invoice_restapi.model.BlackListedJWTTokenModel;

@Component
public class BLackListedJWTTokenUtil {
    
    private Logger logger = LoggerFactory.getLogger(BLackListedJWTTokenUtil.class);

    @Autowired
    private BlackListedJWTTokenRepository blackListedJWTTokenRepository;

  
    public void saveTheGeneratedToken(String username, String jwtToken,boolean valid) {
        BlackListedJWTTokenModel blackListedJWTTokenModel = new BlackListedJWTTokenModel();

        blackListedJWTTokenModel.setUsername(username);
        blackListedJWTTokenModel.setJwtToken(jwtToken);
        blackListedJWTTokenModel.setValid(valid);

        // before it stores the data it should check if there is any old token available.
        if (this.blackListedJWTTokenRepository.existsByUsername(username)) {
            this.blackListedJWTTokenRepository.deleteById(this.blackListedJWTTokenRepository.findByUsername(username).getId());
        }
        this.blackListedJWTTokenRepository.save(blackListedJWTTokenModel);
    }
    
}
