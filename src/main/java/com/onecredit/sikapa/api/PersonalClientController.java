package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.dto.PersonalClientDTO;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import com.onecredit.sikapa.domain.services.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class PersonalClientController {

    private PersonalClientService clientService;

    @Autowired
    public PersonalClientController(PersonalClientService clientService){
        this.clientService=clientService;
    }


    @GetMapping(path ="/clients/personal",produces = "application/json")
    public ResponseEntity<List<PersonalClientDTO>>index(){
        return ResponseEntity.ok(this.clientService.all());
    }

    @PostMapping(path = "/clients/personal",consumes = "application/json",produces = "application/json")
    public PersonalClient create(@RequestBody PersonalClient client,Authentication auth){

          return this.clientService.createClient(client,auth.getName());
    }

}
