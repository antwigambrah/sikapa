package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.dto.BranchDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.services.BranchService;

@RestController
@RequestMapping(path = "/api")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping(path = "/branches", consumes = "application/json", headers = "Accept=application/json")
    public Branch create(@Valid @RequestBody Branch branch) {
        return this.branchService.createBranch(branch);
    }

    @GetMapping(path = "/branches",produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<BranchDTO>> findAll() {
        return ResponseEntity.ok(this.branchService.all());
    }

}
