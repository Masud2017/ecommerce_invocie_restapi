package com.ecommerce.invoice_restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="invoiceaddress")
public class InvoiceAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="invoiceinfo_id")
    @JsonBackReference
    private InvoiceInfo invoiceinfo;


    private String zipCode;
    private String address;
    private String city;
    private String district;
    private String phoneNumber;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvoiceInfo getInvoiceinfo() {
        return this.invoiceinfo;
    }

    public void setInvoiceinfo(InvoiceInfo invoiceinfo) {
        this.invoiceinfo = invoiceinfo;
    }
    


    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
