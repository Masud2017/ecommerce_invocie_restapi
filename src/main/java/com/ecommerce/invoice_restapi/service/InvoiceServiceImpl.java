package com.ecommerce.invoice_restapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecommerce.invoice_restapi.dao.InvoiceInfoRepository;
import com.ecommerce.invoice_restapi.dao.UserRepository;
import com.ecommerce.invoice_restapi.model.DeletedResponseModel;
import com.ecommerce.invoice_restapi.model.InvoiceAddress;
import com.ecommerce.invoice_restapi.model.InvoiceGenerationStatus;
import com.ecommerce.invoice_restapi.model.InvoiceInfo;
import com.ecommerce.invoice_restapi.model.InvoiceProduct;
import com.ecommerce.invoice_restapi.model.User;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InvoiceInfoRepository invoiceInfoRepository;

    @Override
    public InvoiceInfo addInvoice(InvoiceInfo invoiceInfo) throws ParseException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        InvoiceAddress address = invoiceInfo.getAddress();
        InvoiceProduct product = invoiceInfo.getInvoiceProduct();

        address.setInvoiceinfo(invoiceInfo);
        product.setInvoiceinfo(invoiceInfo);

        user.getInvoiceInfo().add(invoiceInfo);

        invoiceInfo.setUser(user);

        //"dd/MM/yyyy hh.mm aa"
        invoiceInfo.setCreatedAt(new SimpleDateFormat().parse(new SimpleDateFormat().format(Calendar.getInstance().getTime())));

        this.userRepository.save(user);
        this.invoiceInfoRepository.save(invoiceInfo);
        

        return invoiceInfo;
    }

    @Override
    public InvoiceInfo getInvoice(String invoiceId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = this.userRepository.findByEmail(userDetails.getUsername());
        InvoiceInfo returnableInfo = new InvoiceInfo();

        Set<InvoiceInfo> invoiceList = user.getInvoiceInfo();

        invoiceList.forEach(item -> {
            if (item.getId().equals(Long.valueOf(invoiceId))) {

                returnableInfo.setAddress(item.getAddress());
                returnableInfo.setCreatedAt(item.getCreatedAt());
                returnableInfo.setId(item.getId());
                returnableInfo.setInvoiceProduct(item.getInvoiceProduct());
                returnableInfo.setIsPaid(item.getIsPaid());
                returnableInfo.setPaymentType(item.getPaymentType());
                returnableInfo.setSubTotal(item.getSubTotal());
                returnableInfo.setTotal(item.getTotal());
                returnableInfo.setUserName(item.getUserName());

            }
        });

        return returnableInfo;
    }

    @Override
    public DeletedResponseModel deleteInvoice(String invoiceId) {
        InvoiceInfo invoiceInfo = this.invoiceInfoRepository.findById(Long.valueOf(invoiceId)).get();
        this.invoiceInfoRepository.delete(invoiceInfo);
        
        DeletedResponseModel modelResponse = new DeletedResponseModel();
        modelResponse.setMsg("Invoice with id "+invoiceId+" is deleted");

        return modelResponse;
    }

    @Override
    public InvoiceInfo editInvoice(String invoiceId, InvoiceInfo invoiceInfo) {
        InvoiceInfo invoice = this.invoiceInfoRepository.findById(Long.valueOf(invoiceId)).get();

        invoice.setAddress(invoiceInfo.getAddress());
        invoice.setId(invoiceInfo.getId());
        invoice.setInvoiceProduct(invoiceInfo.getInvoiceProduct());
        invoice.setCreatedAt(invoiceInfo.getCreatedAt());
        invoice.setIsPaid(invoiceInfo.getIsPaid());
        invoice.setPaymentType(invoiceInfo.getPaymentType());
        invoice.setSubTotal(invoiceInfo.getSubTotal());
        invoice.setTotal(invoiceInfo.getTotal());
        invoice.setUser(invoiceInfo.getUser());
        invoice.setUserName(invoiceInfo.getUserName());

        this.invoiceInfoRepository.save(invoice);

        return invoice;
    }

    @Override
    public Set<InvoiceInfo> getAllInvoiceThisUserHas() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());
        Set<InvoiceInfo> invoiceList = user.getInvoiceInfo();

        return invoiceList;
    }

  

    @Override
    public Set<InvoiceInfo> getAllInvoiceThisUserHasPaged(Integer pageNo, Integer pageSize) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        Pageable paging = PageRequest.of(pageNo,pageSize);

        Page<InvoiceInfo> invoiceListPaged = this.invoiceInfoRepository.findAll(paging);
        Set<InvoiceInfo> filteredSet = invoiceListPaged.toList()
                                                    .stream()
                                                    .filter(item->item.getUser().getId() == user.getId())
                                                    .collect(Collectors.toSet());

        return filteredSet;
    }

    @Override
    public InvoiceGenerationStatus generateInvoice(Integer invoiceId) {
        InvoiceGenerationStatus status = new InvoiceGenerationStatus();

        return status;
    }

    /**
     * This method is responsible for sending the generated pdf / jpg/ png to the google drive
     * 
     * @return status - Integer - The status of the sending process
     */
    private Integer sendGeneratedAssetToCloud() {
        return null;
    }
    
}
