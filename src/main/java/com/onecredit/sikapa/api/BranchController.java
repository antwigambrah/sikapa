package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.dto.BranchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.services.BranchService;


@RestController
@RequestMapping(path = "/api")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }


    /**
     * Create Branch
     *
     * @param branch Branch
     * @return Branch
     */
    @PostMapping(path = "/branches", consumes = "application/json", headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BranchDTO create(@RequestBody Branch branch) {
        return this.branchService.createBranch(branch);
    }


    /**
     * Update Branch
     *
     * @param id Branch id
     * @param branch Branch
     * @return Branch
     */
    @PatchMapping(path="/branches/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BranchDTO update(@PathVariable(value = "id") Long id, @RequestBody Branch branch){
        return this.branchService.updateBranch(id,branch);
    }

    /**
     * Find Branch
     *
     * @param id Branch id
     * @return Branch
     */
    @GetMapping(path="/branches/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BranchDTO find(@PathVariable(value = "id") Long id){
        return this.branchService.findBranchById(id);
    }


    /**
     * Delete Branch
     *
     * @param id Branch
     * @return Branch
     */
    @RequestMapping(path = "/branches/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>delete (@PathVariable(value="id") Long id){
        this.branchService.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    /**
     * Retrieve Branches
     *
     * @return Branches
     */

    @GetMapping(path = "/branches",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BranchDTO>> all() {
        return ResponseEntity.ok(this.branchService.all());
    }

}
