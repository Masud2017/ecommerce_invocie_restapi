package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BlackListedJWTTokenTest {
    @Test
    public void testBlackListedJWTToken() {
        // given
        BlackListedJWTTokenModel model = new BlackListedJWTTokenModel();

        // when
        model.setId(Long.valueOf("232"));
        model.setJwtToken("jwtToken");
        model.setUsername("username");
        model.setValid(true);

        // then
        assertTrue(model.getId() != null);
        assertTrue(model.getJwtToken() != null);
        assertTrue(model.getUsername() != null);
        assertTrue(model.getValid());
        assertTrue(model.isValid());
        assertTrue(model.toString() != null);
    }
    
}
