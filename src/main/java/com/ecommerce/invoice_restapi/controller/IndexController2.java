package com.ecommerce.invoice_restapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.TestModel;

@RestController
public class IndexController2 {
    @GetMapping("/hello") 
    public TestModel hello() {
        TestModel model = new TestModel();
        model.setAge(23);
        model.setName("masdu karim");
        return model;
    }
}
