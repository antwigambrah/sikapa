package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.Guarantor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuarantorRepository extends JpaRepository<Guarantor,Long> {
}
