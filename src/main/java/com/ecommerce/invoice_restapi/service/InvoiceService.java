package com.ecommerce.invoice_restapi.service;

import java.util.List;

import com.ecommerce.invoice_restapi.model.InvoiceInfo;

public interface InvoiceService {
    public InvoiceInfo addInvoice(InvoiceInfo invoiceInfo);
    public boolean deleteInvoice(String invoiceId);
    public InvoiceInfo editInvoice (String invoiceId);
    public List<InvoiceInfo> getAllInvoiceThisUserHas(); // this should be an authenticated access
}
