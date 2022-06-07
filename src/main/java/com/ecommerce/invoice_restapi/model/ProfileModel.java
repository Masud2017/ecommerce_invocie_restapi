package com.ecommerce.invoice_restapi.model;

public class ProfileModel {
    private String username;
    private String name;
    private String email;
    private UserAddress address;


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    public UserAddress getAddress() {
        return this.address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    
}
