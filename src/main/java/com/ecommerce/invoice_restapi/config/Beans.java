package com.ecommerce.invoice_restapi.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Beans {
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }    

    // @Bean
    // public JavaMailSender getJavaMailSender() {
    //     JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    //     mailSender.setHost("smtp.gmail.com");
    //     mailSender.setPort(587);
        
    //     mailSender.setUsername("msmasud578@gmail.com");
    //     mailSender.setPassword("@ifihaveabird0433");
        
    //     Properties props = mailSender.getJavaMailProperties();
    //     props.put("mail.transport.protocol", "smtp");
    //     props.put("mail.smtp.auth", "true");
    //     props.put("mail.smtp.starttls.enable", "true");
    //     props.put("mail.debug", "true");
        
    //     return mailSender;
    // }
}
