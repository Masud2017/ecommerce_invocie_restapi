package com.ecommerce.invoice_restapi.model;

public class InvoiceGenerationStatus {
    private Integer statusCode;
    private String msg;


    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
