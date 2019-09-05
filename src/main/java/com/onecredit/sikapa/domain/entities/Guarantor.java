package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Null;


@Table
@Entity
@Getter
@Setter
public class Guarantor {
    enum Relationship{
        MOTHER,
        FATHER,
        SISTER,
        BROTHER,
        SISTER_IN_LAW,
        BROTHER_IN_LAW,
        MOTHER_IN_LAW,
        FATHER_IN_LAW,
        COLLEAGUE,
        FRIEND
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String  surname;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Loan loan;

    public Guarantor(String firstName, String middleName, String surname, String houseNumber, String mobileNumber, Relationship relationship) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.houseNumber = houseNumber;
        this.mobileNumber = mobileNumber;
        this.relationship = relationship;
    }

    public  Guarantor(){

    }
}
