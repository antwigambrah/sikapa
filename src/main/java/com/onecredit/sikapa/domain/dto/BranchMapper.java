package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BranchMapper {
    BranchDTO toBranchDTO(Branch branch);

    List<BranchDTO> toBranchDTOs(List<Branch> branches);

    Branch toBranch(BranchDTO branchDTO);
}
