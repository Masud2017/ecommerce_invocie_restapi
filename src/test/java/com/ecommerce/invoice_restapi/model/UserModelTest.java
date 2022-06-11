package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserModelTest {
    
    @Test
    public void testUserModelResponse() {
        // Given 
        User user = new User();
        UserAddress userAddress = new UserAddress();
        // when
        user.setEmail("msmasud578@gmail.com");
        user.setEnabled(true);
        user.setFirstName("Masud");
        user.setLastName("karim");
        user.setPassword("jpmasudxp");
        user.setVerificationCode("nothing");
        user.setId(Long.valueOf("12"));
        user.setUserAddress(userAddress);

        // then
        assertTrue(!user.toString().isEmpty());
        assertTrue(user.getEmail() != null);
        assertTrue(user.getEnabled());
        assertTrue(user.getFirstName() != null);
        assertTrue(user.getLastName() != null);
        assertTrue(user.getId() != null);
        assertTrue(user.getPassword() != null);
        assertTrue(user.getUserAddress() != null);
        assertTrue(user.getVerificationCode() != null);
        assertTrue(user.isEnabled());
    }
    
}
