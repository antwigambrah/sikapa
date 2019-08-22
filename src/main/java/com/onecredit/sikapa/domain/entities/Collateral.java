package com.onecredit.sikapa.domain.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Collateral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private double value;

    public Collateral(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public Collateral(){

    }
}
