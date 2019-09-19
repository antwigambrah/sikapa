package com.onecredit.sikapa.api;


import com.onecredit.sikapa.domain.dto.LoanDTO;
import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.entities.Loan;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.services.AwsS3Service;
import com.onecredit.sikapa.domain.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class LoanController {

    private LoanService loans;

    private AwsS3Service s3ServiceImp;

    @Autowired
    public LoanController(LoanService loans, AwsS3Service s3ServiceImp) {
        this.loans = loans;
        this.s3ServiceImp = s3ServiceImp;
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


    /**
     * Find Loan
     *
     * @param id Long
     * @return Loan
     */
    @GetMapping(path = "loan/{id}",produces = "application/json")
    public LoanDTO find(@PathVariable Long id){
        return this.loans.findLoan(id);
    }


    /**
     * Update Loan
     *
     * @param id Long
     * @param loan Loan
     * @return Loan
     */
    @PatchMapping(path = "/loan/{id}",produces = "application/json")
    public LoanDTO update(@PathVariable Long id,@RequestBody Loan loan){
    return loans.updateLoan(id,loan);
    }

}
