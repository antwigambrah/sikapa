package com.onecredit.sikapa.api;


import com.onecredit.sikapa.domain.dto.LoanDTO;
import com.onecredit.sikapa.domain.entities.Loan;
import com.onecredit.sikapa.domain.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class LoanController {

    private LoanService loans;


    @Autowired
    public LoanController(LoanService loans) {
        this.loans = loans;
    }

    /**
     * Get Loans
     *
     * @return loans Loan
     */
    @GetMapping(path = "/loan",produces = "application/json")
    public List<LoanDTO> index(){
        return this.loans.all();
    }


    /**
     * Create Loan
     *
     * @param loan Loan
     * @param auth Authentication
     * @return Loan
     */
    @PostMapping(path = "loan",consumes = "application/json",produces = "application/json")
    public LoanDTO create(@RequestBody Loan loan, Authentication auth){

        return this.loans.createLoan(loan,auth);
    }
}
