package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VerificationCodeModelTest {
    @Test
    public void testVerificationCodeModelResponse() {
        // Given
        VerificationCodeModel model = new VerificationCodeModel();
        // when
        model.setCode("code");
        // then
        assertTrue(model.getCode() != null);
    }
    
}
