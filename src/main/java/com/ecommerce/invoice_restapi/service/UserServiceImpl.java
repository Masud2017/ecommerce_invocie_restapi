package com.ecommerce.invoice_restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecommerce.invoice_restapi.dao.UserAddressRepository;
import com.ecommerce.invoice_restapi.dao.UserRepository;
import com.ecommerce.invoice_restapi.model.ProfileModel;
import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.UserAddress;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public ProfileModel me() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());
        
        ProfileModel profileModel = new ProfileModel();
        profileModel.setUsername(user.getEmail());
        profileModel.setEmail(user.getEmail());
        profileModel.setName(user.getFirstName() + " "+ user.getLastName());
        profileModel.setAddress(user.getUserAddress());

        return profileModel;
    }

    @Override
    public User addUserAddress(UserAddress userAddress) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        // userAddress.setUser(user);
        
        // user.setUserAddress(userAddress);
        // this.userRepository.save(user);

        return user;
    }
    
}
