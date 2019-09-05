package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends  JpaRepository<Loan,Long> {
}
