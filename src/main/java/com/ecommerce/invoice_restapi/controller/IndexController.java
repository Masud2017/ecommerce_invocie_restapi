package com.ecommerce.invoice_restapi.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String hello() {
        logger.info("This is my stuff");
        System.out.println("invoked fsdfasdf dsaf asdfasd fsad f asdfsad fasd fasdfas ");
        return "Helljo";
    }
}
