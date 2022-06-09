// package com.ecommerce.invoice_restapi.util;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.ecommerce.invoice_restapi.dao.BlackListedJWTTokenRepository;
// import com.ecommerce.invoice_restapi.model.BlackListedJWTTokenModel;

// @Component
// public class BLackListedJWTTokenUtil {
//     private String username;
//     private String jwtToken;
//     private boolean isValid;
//     private BlackListedJWTTokenModel blackListedJWTTokenModel;

//     @Autowired
//     private BlackListedJWTTokenRepository blackListedJWTTokenRepository;

//     public BLackListedJWTTokenUtil(){}

//     public BLackListedJWTTokenUtil(String username, String jwtToken, boolean isValid) {
//         this.username = username;
//         this.jwtToken = jwtToken;
//         this.isValid = isValid;
//         this.blackListedJWTTokenModel = new BlackListedJWTTokenModel();
//     }

//     public void saveTheGeneratedToken() {
//         this.blackListedJWTTokenModel.setUsername(this.username);
//         this.blackListedJWTTokenModel.setJwtToken(this.jwtToken);
//         this.blackListedJWTTokenModel.setValid(this.isValid);

//         // before it stores the data it should check if there is any old token available.
//         if (this.blackListedJWTTokenRepository.existsByUsername(this.username)) {
//             this.blackListedJWTTokenRepository.deleteById(this.blackListedJWTTokenRepository.findByUsername(this.username).getId());
//         }
//         this.blackListedJWTTokenRepository.save(this.blackListedJWTTokenModel);

//     }
    
// }
