package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.IndividualClient;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;
import java.time.LocalDate;
@Transactional
@Getter
@Setter
public class IndividualClientDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String surname;
    private IndividualClient.Gender gender;
    private IndividualClient.MaritalStatus maritalStatus;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private int age;
    private String nextOfKin;
    private String nationality;
    private String occupation;
    private Branch branch;
    private Client individual;
}
