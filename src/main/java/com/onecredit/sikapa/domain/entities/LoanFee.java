package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
public class LoanFee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;
    @Column(nullable = false)
    private int tenure;
    @Column(nullable = false)
    private  String months;
    @Column(nullable = false)
    private  double rate;

    public LoanFee(int tenure, String months, double rate) {
        this.tenure = tenure;
        this.months = months;
        this.rate = rate;
    }
    public LoanFee(){

    }
}
