package com.ecommerce.invoice_restapi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="invoiceinfo")
public class InvoiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    private String userName;
    private Date createdAt;
    private boolean isPaid;
    private String paymentType;
    // private String clientAddress;
    // private String clientZipCode;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "invoiceinfo")
    @JsonManagedReference
    private InvoiceAddress address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "invoiceinfo")
    @JsonManagedReference
    private InvoiceProduct invoiceProduct;
    
    
}
