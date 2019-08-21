package com.onecredit.sikapa.exceptions;

public class ResourceNotFoundException  extends Exception{

    public ResourceNotFoundException(Long resourceId, String resource) {
        super(String.format(resource + " is not found with id :", "%s",resourceId));
    }

}