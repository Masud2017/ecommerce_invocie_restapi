package com.ecommerce.invoice_restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.invoice_restapi.model.BlackListedJWTTokenModel;

@Repository
public interface BlackListedJWTTokenRepository extends CrudRepository<BlackListedJWTTokenModel,Long> {
    public BlackListedJWTTokenModel findByUsername(String username);
    public boolean existsByUsername(String username);
}
