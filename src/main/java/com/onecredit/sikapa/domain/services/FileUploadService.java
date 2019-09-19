package com.onecredit.sikapa.domain.services;

import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public abstract class FileUploadService {

    public abstract String upload(String base64Image);
    public abstract void  delete(String key);
    public abstract void download(String key, String file);


    /**
     * Create New Image
     *
     * @param base64File
     * @return image Path
     */
   byte[] decodeBase64File(String base64File){

        return  Base64.getDecoder().decode(base64File.split(",")[1]);
    }

    Map<String ,String> generateFileName(String bas464File){

                String fileContentType=bas464File.split(";")[0].split(":")[1];
                String fileType=fileContentType.split("/")[1];

        //Generate image name as current time milliseconds;
        Date date= new Date();

        Map<String,String>file=new HashMap<>();

        file.put("name",date.getTime()+"."+fileType);
        file.put("content-type",fileContentType);

      return file;


    }
}
