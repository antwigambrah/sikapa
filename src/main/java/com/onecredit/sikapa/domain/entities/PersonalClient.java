package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal_client")
@Getter
@Setter
public class PersonalClient {

    public enum MaritalStaus {
        SINGLE,
        MARRIED,
        DIVORCED
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = true)
    private String middleName;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStaus maritalStatus;

    @Type(type = "date")
    private Date dateOfBirth;
    @Column(nullable = false)
    private String placeOfBirth;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String nextOfKin;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private String occupation;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;


    @Column(nullable = false)
    @Embedded
    private Client personal;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public PersonalClient(String firstName, String middleName, String surname, String gender, String maritalStatus, Date dateOfBirth, String placeOfBirth, int age, String nextOfKin, String nationality, String occupation, Client personal) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.gender = Gender.valueOf(gender);
        this.maritalStatus = MaritalStaus.valueOf(maritalStatus);
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.age = age;
        this.nextOfKin = nextOfKin;
        this.nationality = nationality;
        this.occupation = occupation;
        this.personal = personal;
    }

    public PersonalClient() {

    }

}
