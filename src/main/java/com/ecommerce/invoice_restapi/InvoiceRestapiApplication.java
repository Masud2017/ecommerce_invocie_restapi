package com.ecommerce.invoice_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;



@SpringBootApplication
@ServletComponentScan
public class InvoiceRestapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(InvoiceRestapiApplication.class, args);
	}

}
