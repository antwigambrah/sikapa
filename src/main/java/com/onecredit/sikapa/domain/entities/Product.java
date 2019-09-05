package com.onecredit.sikapa.domain.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity(name = "Product")
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    protected Long id;
    @Column(nullable =  false)
    private String name;
    @Column(nullable = false)
    private double minimumAmount;
    @Column(nullable = false)
    private double maximumAmount;
    @Column(nullable = false)
    private Integer repaymentPeriod;
    @Column(nullable = false)
    private double interestRate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Loan>loans=new ArrayList<>();

    public Product(String name, double minimumAmount, double maximumAmount, Integer repaymentPeriod) {
        this.name = name;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.repaymentPeriod = repaymentPeriod;
    }

    public Product(){

    }



}
