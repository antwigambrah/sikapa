package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findBranchByArea(String area);

}
