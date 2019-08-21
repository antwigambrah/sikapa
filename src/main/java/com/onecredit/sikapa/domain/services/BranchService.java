package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.BranchDTO;
import com.onecredit.sikapa.domain.dto.BranchMapper;
import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
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


    public BranchDTO createBranch(Branch branch) {
         Branch branch1=this.branchRepository.save(branch);
        return this.branchMapper.toBranchDTO(branch1);
    }

    public BranchDTO updateBranch(Long id, Branch branch){
        // TODO CREATE A CUSTOM EXCEPTION TO HANDLE DATA NOT FOUND
        Branch branch1=this.branchRepository.findById(id).orElse(new Branch());
        if (branch.getArea()!=null) {
            branch1.setArea(branch.getArea());
        }
        if(branch.getRegion()!=null){
            branch1.setRegion(branch.getRegion());
        }
        return this.branchMapper.toBranchDTO(branch);
    }

    public void deleteUser(Long id){
        Branch user=this.branchRepository.findById(id).orElse(new Branch());
        this.branchRepository.delete(user);
    }

    public BranchDTO findBranchById(Long Id) {
        Branch branch=this.branchRepository.findById(Id).orElse(new Branch());
        return this.branchMapper.toBranchDTO(branch);
    }

    public List<BranchDTO> all() {
        return this.branchMapper.toBranchDTOs(this.branchRepository.findAll());
    }

}
