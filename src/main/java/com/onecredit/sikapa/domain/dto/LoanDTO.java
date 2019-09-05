package com.onecredit.sikapa.domain.dto;


import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.Loan;
import com.onecredit.sikapa.domain.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Transactional
public class LoanDTO {
    private Long id;
    private double amount;
    private String clientName;
    private  String  accountNumber;
    private LocalDate startDate;
    private LocalDate initiateDate;
    private LocalDate endDate;
    private User user;
    private Loan.LoanStatus status;
}
