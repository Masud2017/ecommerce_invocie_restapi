package com.ecommerce.invoice_restapi.service;

import com.ecommerce.invoice_restapi.model.ProfileModel;
import com.ecommerce.invoice_restapi.model.User;
import com.ecommerce.invoice_restapi.model.UserAddress;

public interface UserService {
    public ProfileModel me();
    public User addUserAddress(UserAddress userAddress);
}
