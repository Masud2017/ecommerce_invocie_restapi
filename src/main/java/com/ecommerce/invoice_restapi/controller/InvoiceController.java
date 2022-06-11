package com.ecommerce.invoice_restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.dao.InvoiceInfoRepository;
import com.ecommerce.invoice_restapi.model.InvoiceAddress;
import com.ecommerce.invoice_restapi.model.InvoiceInfo;
import com.ecommerce.invoice_restapi.model.InvoiceProduct;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
public class InvoiceController {
    @Autowired
    private InvoiceInfoRepository invoiceInfoRepository;

    @GetMapping("/addinvoice")
    public InvoiceInfo addInvoice() {
        InvoiceInfo invoice = new InvoiceInfo();
        InvoiceAddress address = new InvoiceAddress();
        InvoiceProduct product = new InvoiceProduct();

        invoice.setAddress(address);
        invoice.setInvoiceProduct(product);
        invoice.setIsPaid(true);

        address.setInvoiceinfo(invoice);
        product.setInvoiceinfo(invoice);

        this.invoiceInfoRepository.save(invoice);

        return invoice;
    }
    
}
