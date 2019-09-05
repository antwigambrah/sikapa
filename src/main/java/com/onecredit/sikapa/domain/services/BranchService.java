package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.BranchDTO;
import com.onecredit.sikapa.domain.dto.BranchMapper;
import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class BranchService {
    private final BranchRepository branchRepository;
    private  final BranchMapper branchMapper;

    @Autowired
    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }


    /**
     * Get Branches
     *
     * @return Branches
     */
    public List<BranchDTO> all() {
        return this.branchMapper.toBranchDTOs(this.branchRepository.findAll());
    }

    /**
     * Create Branch
     *
     * @param branch Branch
     * @return Branch
     */
    public BranchDTO createBranch(Branch branch) {
         Branch branch1=this.branchRepository.save(branch);
        return this.branchMapper.toBranchDTO(branch1);
    }

    /**
     * Update Branch
     *
     * @param id Id
     * @param branch Branch
     * @return Branch
     */
    public BranchDTO updateBranch(Long id, Branch branch){
        Branch branch1=this.branchRepository.findById(id).orElse(new Branch());
        if (branch.getArea()!=null) {
            branch1.setArea(branch.getArea());
        }
        if(branch.getRegion()!=null){
            branch1.setRegion(branch.getRegion());
        }
        return this.branchMapper.toBranchDTO(branch);
    }

    /**
     * Delete Branch
     *
     * @param id Id
     */
    public void deleteBranch(Long id){
        Branch user=this.branchRepository.findById(id).orElse(new Branch());
        this.branchRepository.delete(user);
    }

    /**
     * Find Branch
     *
     * @param Id Id
     * @return Branch
     */
    public BranchDTO findBranchById(Long Id) {
        Branch branch=this.branchRepository.findById(Id).orElse(new Branch());
        return this.branchMapper.toBranchDTO(branch);
    }



}
