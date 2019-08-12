package com.onecredit.sikapa.domain.repositories;

import com.onecredit.sikapa.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findBranchByArea(String area);

}
