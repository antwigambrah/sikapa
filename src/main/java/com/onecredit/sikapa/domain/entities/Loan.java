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
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Table
@Getter
@Setter
@Entity
public class Loan {

    public enum LoanStatus{
        INITIATED,
        APPROVED,
        DISBURSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String clientName;
    @Column(nullable = false)
    private String clientPhoneNumber;
    @Column(nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    @Lob
    private String purpose;
    @Column(nullable = false)
    private double amount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate initiateDate;
    @Column(nullable = false)
    private double commitmentFee;
    @Column(nullable = false)
    private double insurancePremium;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(nullable = false)
    private String sourceOfIncome;

    @Column(nullable = false)
    private String collateral;

    @Lob
    private String comments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Guarantor> guarantors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  User user;

    @Column(nullable = true)
    private String documents;

    public Loan(double amount, LocalDate startDate, LocalDate endDate,String sourceOfIncome,String accountNumber, String collateral, Product product, double commitmentFee,User user,double insurancePremium,LoanStatus status,String comments,String purpose,String clientName,String clientPhoneNumber,String documents) {
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collateral = collateral;
        this.product = product;
        this.commitmentFee=commitmentFee;
        this.insurancePremium=insurancePremium;
        this.status=status;
        this.user=user;
        this.comments=comments;
        this.purpose=purpose;
        this.sourceOfIncome=sourceOfIncome;
        this.clientName=clientName;
        this.clientPhoneNumber=clientPhoneNumber;
        this.accountNumber=accountNumber;
        this.documents=documents;
    }

    public  Loan(){


    }



}
