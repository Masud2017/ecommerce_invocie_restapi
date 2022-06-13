package com.ecommerce.invoice_restapi.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.messaging.Message;

@Service
public class FirebaseStorageService implements StorageService {
    @Autowired
    private FirebaseOptions options;
    @Value("${firebase.bucketname}")
    private String bucketName;
    private String  fileNamePrefix = "data";
    private String backupFolderPath = "csvfile/";

    private StorageClient client;
    private Logger logger = LoggerFactory.getLogger(FirebaseStorageService.class);

    @PostConstruct
    public void setup() {

        if (FirebaseApp.getApps().isEmpty()) {
            logger.info(options.getStorageBucket());
            FirebaseApp.initializeApp(options);
        }
        this.client = StorageClient.getInstance();
    }


    @Override
    public boolean save(Object entity) throws IOException, URISyntaxException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String timestamp = dateFormat.format(date);

        
        String objectName = backupFolderPath + fileNamePrefix + "_" + timestamp + ".pdf";
        BlobId blobId = BlobId.of(this.bucketName, objectName);
        BlobInfo blob = BlobInfo.newBuilder(blobId)
        .setContentType("application/pdf")
        .setContentEncoding("utf-8").build();

        
        
        client.bucket(this.bucketName).getStorage().create(blob,Files.readAllBytes(Paths.get(Resources.getResource("jh.pdf").toURI())));
        
        
        return true;
    }


    @Override
    public URI downloadFile(String invoicePdfId) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean deleteAFile(String invoicePdfId) {
             
        return false;
    }

    
    
}
