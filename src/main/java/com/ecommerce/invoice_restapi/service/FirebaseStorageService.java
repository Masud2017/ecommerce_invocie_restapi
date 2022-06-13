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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

@Service
public class FirebaseStorageService implements StorageService {
    @Autowired
    private FirebaseOptions options;
    @Value("${firebase.bucketname}")
    private String bucketName;
    private String  fileNamePrefix = "nob";
    private String backupFolderPath = "nothing/";

    @PostConstruct
    public void setup() {
        if (FirebaseApp.getApps().isEmpty()) {
            
            FirebaseApp.initializeApp(options,options.getStorageBucket());
        }
    }


    @Override
    public boolean save(Object entity) throws IOException, URISyntaxException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String timestamp = dateFormat.format(date);

        
        String objectName = backupFolderPath + fileNamePrefix + "_" + timestamp + ".csv";
        BlobId blobId = BlobId.of(this.bucketName, objectName);
        BlobInfo blob = BlobInfo.newBuilder(blobId)
        .setContentType("text/csv")
        .setContentEncoding("utf-8").build();

        StorageClient client = StorageClient.getInstance();

        client.bucket().getStorage().create(blob,Files.readAllBytes(Paths.get(Resources.getResource("data.csv").toURI())));
        return true;
    }


    @Override
    public URI downloadFile() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
