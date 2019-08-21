package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.dto.IndividualClientDTO;
import com.onecredit.sikapa.domain.entities.IndividualClient;
import com.onecredit.sikapa.domain.services.IndividualClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class IndividualClientController {

    private IndividualClientService clientService;

    @Autowired
    public IndividualClientController(IndividualClientService clientService){
        this.clientService=clientService;
    }

    /**
     * Retrieve Individual Clients
     *
     * @return Clients
     */

    @GetMapping(path ="/clients/individual",produces = "application/json")
    public ResponseEntity<List<IndividualClientDTO>>index(){
        return ResponseEntity.ok(this.clientService.all());
    }

    /**
     * Create Individual Client
     *
     * @param client PersonalClient
     * @param auth Authentication
     * @return PersonalClientDTO
     */
    @PostMapping(path = "/clients/individual",consumes = "application/json",produces = "application/json")
    public IndividualClientDTO create(@RequestBody IndividualClient client, Authentication auth){

          return this.clientService.createClient(client,auth.getName());
    }

}
