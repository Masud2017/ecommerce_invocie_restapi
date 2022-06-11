package com.ecommerce.invoice_restapi.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Test;

public class ProfileModelTest {
    @Test
    public void testProfileModel() {
        // given
        ProfileModel model = new ProfileModel();
        UserAddress userAddress = new UserAddress();
        // when
        model.setAddress(userAddress);
        model.setEmail("email");
        model.setName("name");
        model.setUsername("username");
        // then

        assertTrue(model.getAddress() != null);
        assertTrue(model.getEmail() != null);
        assertTrue(model.getName() != null);
        assertTrue(model.getUsername() != null);
    }
}
