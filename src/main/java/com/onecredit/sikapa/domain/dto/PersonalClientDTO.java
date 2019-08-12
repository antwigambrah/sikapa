package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Getter
@Setter
public class PersonalClientDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String surname;
    private PersonalClient.Gender gender;
    private PersonalClient.MaritalStaus maritalStaus;
    private Date dateOfBirth;
    private String placeOfBirth;
    private int age;
    private String nextOfKin;
    private String nationality;
    private String occupation;
    private Client personal;

}
