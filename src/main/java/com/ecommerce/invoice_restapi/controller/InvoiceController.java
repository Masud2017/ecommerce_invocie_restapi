package com.ecommerce.invoice_restapi.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.invoice_restapi.model.DeletedResponseModel;
import com.ecommerce.invoice_restapi.model.InvoiceGenerationStatus;
import com.ecommerce.invoice_restapi.model.InvoiceInfo;
import com.ecommerce.invoice_restapi.service.InvoiceService;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PutMapping("/addinvoice")
    public ResponseEntity<InvoiceInfo> addInvoice(@RequestBody InvoiceInfo invoiceInfo) throws ParseException {
        return ResponseEntity.ok(this.invoiceService.addInvoice(invoiceInfo));
    }

    @GetMapping("/getinvoice")
    public ResponseEntity<InvoiceInfo> getInvoice(@RequestParam String invoiceId) {
        return ResponseEntity.ok(this.invoiceService.getInvoice(invoiceId));
    }

    @DeleteMapping("/deleteinvoice")
    public ResponseEntity<DeletedResponseModel> deleteInvoice(@RequestParam String invoiceId) {
        return ResponseEntity.ok(this.invoiceService.deleteInvoice(invoiceId));
    }
    
    @PutMapping("editinvoice/{invoiceId}")
    public ResponseEntity<InvoiceInfo> editInvoice(@PathVariable String invoiceId, @ModelAttribute InvoiceInfo invoiceInfo) {
        return ResponseEntity.ok(this.invoiceService.editInvoice(invoiceId,invoiceInfo));
    }

    @GetMapping("invoices")
    public ResponseEntity<Set<InvoiceInfo>> getAllInvoice() {
        return ResponseEntity.ok(this.invoiceService.getAllInvoiceThisUserHas());
    }

    @GetMapping("invoices/{pageNo}/{pageSize}")
    public ResponseEntity<Set<InvoiceInfo>> getAllInvoicePaged (@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(this.invoiceService.getAllInvoiceThisUserHasPaged(pageNo, pageSize));
    }

    @GetMapping("generateinvoice/{invoiceId}")
    public ResponseEntity<InvoiceGenerationStatus> generateInvoice(@PathVariable Integer invoiceId) {
        return ResponseEntity.ok(this.invoiceService.generateInvoice(invoiceId));
    }
}
