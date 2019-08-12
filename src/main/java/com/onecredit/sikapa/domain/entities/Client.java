package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Embeddable
@Getter
@Setter
public class Client {

    private String phoneNumber;
    private String email;
    private int numberOfDependants;
    private String houseNumber;
    private String town;
    private String postalAddress;
    private String nearestLandmark;
    private String tenancyType;
    private int tenancyDuration;
    private String accountNumber;
    private String gpsAddress;


    public Client(String phoneNumber, String email, int numberOfDependants, String houseNumber, String town, String postalAddress, String nearestLandmark, String gpsAddress, String tenancyType, int tenancyDuration, String accountNumber) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfDependants = numberOfDependants;
        this.houseNumber = houseNumber;
        this.town = town;
        this.postalAddress = postalAddress;
        this.nearestLandmark = nearestLandmark;
        this.gpsAddress = gpsAddress;
        this.tenancyType = tenancyType;
        this.tenancyDuration = tenancyDuration;
        this.accountNumber = accountNumber;
    }
    public Client(){

    }
}
