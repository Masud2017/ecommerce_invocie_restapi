package com.ecommerce.invoice_restapi.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;



@RedisHash("jwt_token")
public class BlackListedJWTTokenModel implements Serializable{
    @Id
    @Indexed
    private Long id;

    @Indexed
    private String username;
    @Indexed
    private String jwtToken;
    @Indexed
    private boolean valid;

    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }


    public boolean isValid() {
        return this.valid;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
