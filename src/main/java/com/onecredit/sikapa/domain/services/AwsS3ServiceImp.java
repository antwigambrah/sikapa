package com.onecredit.sikapa.domain.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;


@Service
public class AwsS3ServiceImp extends FileUploadService {


    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public  AwsS3ServiceImp(AmazonS3 amazonS3){
        this.amazonS3=amazonS3;
    }


    @Override
    public String upload(String base64File) {

        byte[]fileBytes=this.decodeBase64File(base64File);
        Map<String,String>file=this.generateFileName(base64File);
        String fileName=file.get("name");
        String fileContentType=file.get("content-type");

        InputStream fis = new ByteArrayInputStream(fileBytes);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileBytes.length);
        metadata.setContentType(fileContentType);
        metadata.setCacheControl("public, max-age=31536000");
        this.amazonS3.putObject(this.bucketName, fileName, fis, metadata);
        this.amazonS3.setObjectAcl(this.bucketName, fileName, CannedAccessControlList.PublicRead);

        return fileName;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void download(String key, String file) {

    }


}
