package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Loan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LoanMapper {
    LoanDTO toLoanDTO(Loan loan);

    List<LoanDTO> toLoanDTOs(List<Loan> loans);
}
