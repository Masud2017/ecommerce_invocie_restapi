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
@Table(name="invoiceproduct")
public class InvoiceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "invoiceinfo_id")
    private InvoiceInfo invoiceinfo;
    

    private String productName;
    private Integer productQuantity;
    private String productUnitPrice;
    private String productTotalQuantityPrice;
    private Integer discount;
    private Integer tax;


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


    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnitPrice() {
        return this.productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductTotalQuantityPrice() {
        return this.productTotalQuantityPrice;
    }

    public void setProductTotalQuantityPrice(String productTotalQuantityPrice) {
        this.productTotalQuantityPrice = productTotalQuantityPrice;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTax() {
        return this.tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    
}
