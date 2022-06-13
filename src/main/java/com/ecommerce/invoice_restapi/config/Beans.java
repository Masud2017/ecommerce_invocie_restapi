package com.ecommerce.invoice_restapi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseOptions;


@Configuration
@EnableRedisRepositories
// @PropertySource("classpath:application.properties")
public class Beans {

    // @Value("${google.CREDENTIALS_FILE_PATH}")
    @Value("${google.CREDENTIALS_FILE_PATH}")
    private String credFilePath;
    @Value("${TOKENS_DIRECTORY_PATH}")
    private String tokenDirectoryPath;

    @Value("${firebase.cred}")
    private String fireBaseCred;
    private Logger logger = LoggerFactory.getLogger(Beans.class);

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }    

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
       return new JedisConnectionFactory();
    }
    
  
    @Bean
    public FirebaseOptions getFireBaseOptions() throws IOException {
        InputStream inputStream = new FileInputStream(Resources.getResource(this.fireBaseCred).getPath());
        return FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(inputStream)).setStorageBucket("invoicerestapi").build();
    }
    
}
