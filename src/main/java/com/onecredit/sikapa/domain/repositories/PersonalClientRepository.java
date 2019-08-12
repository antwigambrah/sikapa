package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.PersonalClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalClientRepository extends JpaRepository<PersonalClient,Long> {
}
