package com.ecommerce.invoice_restapi.service;

import java.io.IOException;

public interface PdfGeneratorService {
    public boolean generate() throws IOException;
}
