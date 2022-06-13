package com.ecommerce.invoice_restapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public interface StorageService {
    public boolean save(Object entity) throws IOException, URISyntaxException;
    public URI downloadFile();
}
