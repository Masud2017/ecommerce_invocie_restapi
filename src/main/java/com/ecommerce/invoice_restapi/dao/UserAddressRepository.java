package com.ecommerce.invoice_restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.invoice_restapi.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {
    public UserAddress findByAddress(String address);
}
