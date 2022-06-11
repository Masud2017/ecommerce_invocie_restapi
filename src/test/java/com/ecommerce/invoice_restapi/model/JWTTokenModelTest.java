package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JWTTokenModelTest {
    @Test
    public void testJWTtokenModel() {
        // given
        JWTTokenModel model = new JWTTokenModel();
        // when 
        model.setBearer("bearer");
        // then
        assertTrue(model.getBearer() != null);
    }
    
}
