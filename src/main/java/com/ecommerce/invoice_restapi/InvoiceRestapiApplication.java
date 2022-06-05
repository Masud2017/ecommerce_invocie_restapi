package com.ecommerce.invoice_restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackageClasses = {IndexController2.class})
public class InvoiceRestapiApplication {
	private static Logger logger = LoggerFactory.getLogger(InvoiceRestapiApplication.class);
	public static void main(String[] args) {
		logger.info("hello this is main file");
		SpringApplication.run(InvoiceRestapiApplication.class, args);
	}

}
