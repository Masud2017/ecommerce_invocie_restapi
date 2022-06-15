package com.ecommerce.invoice_restapi.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.io.Resources;
import com.itextpdf.kernel.pdf.PdfWriter;



@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {
    private File htmlFile;
    private Logger logger = LoggerFactory.getLogger(PdfGeneratorServiceImpl.class);

    public PdfGeneratorServiceImpl() throws Exception {

        this.htmlFile = new File(Resources.getResource("templates/invoicetemplate/index.html").getPath());
            
        PdfWriter writer = new PdfWriter(this.htmlFile);
        

    }

    @Override
    public boolean generate() throws IOException {
        
        
        return false;
    }
    
}
