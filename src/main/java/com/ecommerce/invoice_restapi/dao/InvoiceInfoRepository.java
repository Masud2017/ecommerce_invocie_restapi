package com.ecommerce.invoice_restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.invoice_restapi.model.InvoiceInfo;

public interface InvoiceInfoRepository extends JpaRepository<InvoiceInfo,Long> {
    
}
