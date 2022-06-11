package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserAddressTest {
    @Test
    public void testUserAddress() {
        // given
        UserAddress userAddress = new UserAddress();
        User user = new User();

        // when 
        userAddress.setAddress("address");
        userAddress.setId(Long.valueOf("34"));
        userAddress.setUser(user);
        
        // then
        assertTrue(userAddress.getAddress() != null);
        assertTrue(userAddress.getId() != null);
        assertTrue(userAddress.getUser() != null);
    }
    
}
