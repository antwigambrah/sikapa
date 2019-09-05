package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanProductRepository extends JpaRepository<Product,Long> {
}
