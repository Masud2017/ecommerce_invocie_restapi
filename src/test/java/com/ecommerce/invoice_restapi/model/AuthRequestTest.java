package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AuthRequestTest {
    @Test
    public void testAuthRequest() {
        // given
        AuthRequest authRequest = new AuthRequest();

        // when 
        authRequest.setPassword("password");
        authRequest.setUsername("username");

        // then
        assertTrue(authRequest.getPassword() != null);
        assertTrue(authRequest.getUsername() != null);
        assertTrue(authRequest.toString() != null);
    }
}
