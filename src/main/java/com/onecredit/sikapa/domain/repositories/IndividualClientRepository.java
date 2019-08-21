package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.IndividualClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualClientRepository extends JpaRepository<IndividualClient,Long> {
}
