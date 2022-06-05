package com.ecommerce.invoice_restapi;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.TestModel;

@RestController
public class IndexController2 {
    private Logger logger = LoggerFactory.getLogger(IndexController2.class);
    @GetMapping("/hello") 
    public TestModel hello() {
        TestModel model = new TestModel();
        model.setAge(23);
        model.setName("masdu karim");
        return model;
    }
}
