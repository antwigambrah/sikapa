package com.onecredit.sikapa.domain.services;


import com.onecredit.sikapa.domain.dto.LoanDTO;
import com.onecredit.sikapa.domain.dto.LoanMapper;
import com.onecredit.sikapa.domain.entities.Loan;
import com.onecredit.sikapa.domain.entities.Product;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.LoanProductRepository;
import com.onecredit.sikapa.domain.repositories.LoanRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class LoanService {

    private  final LoanRepository loan;
    private final UserRepository user;
    private final LoanProductRepository product;
    private final LoanMapper mapper;
    private  final AwsS3Service awsS3ServiceImp;
    @Autowired
    public LoanService(LoanRepository loan, UserRepository user, LoanProductRepository product, LoanMapper mapper, AwsS3Service awsS3ServiceImp) {
        this.loan = loan;
        this.user = user;
        this.product = product;
        this.mapper = mapper;
        this.awsS3ServiceImp = awsS3ServiceImp;
    }

    /**
     * Get Loans
     *
     * @return Loans
     */
    public List<LoanDTO>all(){
        return this.mapper.toLoanDTOs(this.loan.findAll());
    }

    /**
     * Create Loan
     *
     * @param loan Loan
     * @param auth Authentication
     */
    public LoanDTO createLoan(Loan loan, Authentication auth){
        String file=this.awsS3ServiceImp.upload(loan.getDocuments());
        LocalDate startDate= LocalDate.parse(loan.getStartDate().toString());
        LocalDate endDate =LocalDate.parse(loan.getEndDate().toString());

          User user=this.user.findByUsername(auth.getName());
          Product product=this.product.findById(loan.getProduct().getId()).orElse(new Product());
          loan.setUser(user);
          loan.setProduct(product);
          loan.setStartDate(startDate);
          loan.setEndDate(endDate);
          loan.setDocuments(file);
          return this.mapper.toLoanDTO(this.loan.save(loan));
    }

    /**
     * Find Loan
     *
     * @param id Long
     * @return Loan
     */
    public LoanDTO findLoan(Long id){
        return this.mapper.toLoanDTO(this.loan.findById(id).orElse(new Loan()));
    }

    /**
     * Update Loan
     * @param id Long
     * @param loan Loan
     * @return Loan
     */
    public LoanDTO updateLoan(Long id,Loan loan){
        Loan loan1=this.loan.findById(id).orElse(new Loan());
        loan1.setStatus(loan.getStatus());
        this.loan.save(loan1);
        return  this.mapper.toLoanDTO(loan1);
    }

}
