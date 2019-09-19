package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.entities.Guarantor;
import com.onecredit.sikapa.domain.entities.Loan;
import com.onecredit.sikapa.domain.repositories.GuarantorRepository;
import com.onecredit.sikapa.domain.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class GuarantorService {

    private final GuarantorRepository guarantors;
    private  final LoanRepository loans;
    private final AwsS3ServiceImp awsS3ServiceImp;

    @Autowired
    public GuarantorService(GuarantorRepository guarantors, LoanRepository loans, AwsS3ServiceImp awsS3ServiceImp){
        this.guarantors = guarantors;
        this.loans = loans;
        this.awsS3ServiceImp = awsS3ServiceImp;
    }

    /**
     * Get Guarantors
     *
     * @return Guarantorw
     */
    @GetMapping(path = "/guarantor")
    public List<Guarantor>all(){
        return this.guarantors.findAll();
    }

    /**
     * Create Guarauntors
     *
     * @param guarantor Guarantor
     */
    @PostMapping(path = "/guarantor")
    public Guarantor create(Guarantor guarantor){
        Loan loan=this.loans.findById(guarantor.getLoan().getId()).orElse(new Loan());
        guarantor.setLoan(loan);
       return  this.guarantors.save(guarantor);
    }
}
