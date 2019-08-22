package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class AccountConduct {
    private double actualBalance;
    private double highestBalance;
    private double creditTurnover;
    private double debitTurnover;
    private double lowestTurnover;
}
