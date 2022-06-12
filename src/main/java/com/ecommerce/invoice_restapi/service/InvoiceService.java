package com.ecommerce.invoice_restapi.service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import com.ecommerce.invoice_restapi.model.DeletedResponseModel;
import com.ecommerce.invoice_restapi.model.InvoiceGenerationStatus;
import com.ecommerce.invoice_restapi.model.InvoiceInfo;

public interface InvoiceService {
    public InvoiceInfo addInvoice(InvoiceInfo invoiceInfo) throws ParseException;
    public InvoiceInfo getInvoice(String invoiceId);
    public DeletedResponseModel deleteInvoice(String invoiceId);
    public InvoiceInfo editInvoice (String invoiceId);
    public Set<InvoiceInfo> getAllInvoiceThisUserHas(); // this should be an authenticated access
    public Set<InvoiceInfo> getAllInvoiceThisUserHasPaged(Integer pageNo,Integer pageSize);
    public InvoiceGenerationStatus generateInvoice(Integer invoiceId);
}
