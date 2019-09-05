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

    @Autowired
    public LoanService(LoanRepository loan, UserRepository user, LoanProductRepository product, LoanMapper mapper) {
        this.loan = loan;
        this.user = user;
        this.product = product;
        this.mapper = mapper;
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

        LocalDate startDate= LocalDate.parse(loan.getStartDate().toString());
        LocalDate endDate =LocalDate.parse(loan.getEndDate().toString());

          User user=this.user.findByUsername(auth.getName());
          Product product=this.product.findById(loan.getProduct().getId()).orElse(new Product());
          loan.setUser(user);
          loan.setProduct(product);
          loan.setStartDate(startDate);
          loan.setEndDate(endDate);
          return this.mapper.toLoanDTO(this.loan.save(loan));
    }


}
