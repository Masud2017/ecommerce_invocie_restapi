package com.ecommerce.invoice_restapi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Integer subTotal;
    private Integer total;

    @ManyToOne
    // @JsonBackReference
    @JsonIgnore
    @JoinColumn(name ="user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "invoiceInfo")
    @JsonManagedReference
    private InvoicePdfModel invoicePdfModel;
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isIsPaid() {
        return this.isPaid;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public InvoiceAddress getAddress() {
        return this.address;
    }

    public void setAddress(InvoiceAddress address) {
        this.address = address;
    }

    public InvoiceProduct getInvoiceProduct() {
        return this.invoiceProduct;
    }

    public void setInvoiceProduct(InvoiceProduct invoiceProduct) {
        this.invoiceProduct = invoiceProduct;
    }
    

    public Integer getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public InvoicePdfModel getInvoicePdfModel() {
        return this.invoicePdfModel;
    }

    public void setInvoicePdfModel(InvoicePdfModel invoicePdfModel) {
        this.invoicePdfModel = invoicePdfModel;
    }

}
