package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.BranchDTO;
import com.onecredit.sikapa.domain.dto.BranchMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class BranchService {
    private final BranchRepository branchRepository;
    private  final BranchMapper branchMapper;

    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    public List<BranchDTO> all() {
        return this.branchMapper.toBranchDTOs(this.branchRepository.findAll());
    }

    public Branch createBranch(Branch branch) {
        return this.branchRepository.save(branch);
    }

    public Optional<Branch> findById(Long Id) {
        return this.branchRepository.findById(Id);
    }
}
