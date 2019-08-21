package com.onecredit.sikapa.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class IndividualClient {

    public enum MaritalStatus {
        SINGLE,
        MARRIED,
        DIVORCED
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
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
    private MaritalStatus maritalStatus;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
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


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Branch branch;


    @Column(nullable = false)
    @Embedded
    private Client individual;


    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedAt;

    public IndividualClient(String firstName, String middleName, String surname, String gender, String maritalStatus, LocalDate dateOfBirth, String placeOfBirth, int age, String nextOfKin, String nationality, String occupation, Client individual) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.gender = Gender.valueOf(gender);
        this.maritalStatus = MaritalStatus.valueOf(maritalStatus);
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.age = age;
        this.nextOfKin = nextOfKin;
        this.nationality = nationality;
        this.occupation = occupation;
        this.individual= individual;
    }

    public IndividualClient() {

    }

}
