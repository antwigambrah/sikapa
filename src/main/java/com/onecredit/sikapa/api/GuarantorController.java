package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.entities.Guarantor;
import com.onecredit.sikapa.domain.services.GuarantorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GuarantorController {


    private GuarantorService guarantor;

    public GuarantorController(GuarantorService guarantor) {
        this.guarantor = guarantor;
    }
    @ResponseStatus(HttpStatus.CREATED)


    public List<Guarantor>index(){
        return this.guarantor.all();
    }

    @PostMapping(path = "/guarantor",consumes = "application/json")
    public Guarantor create(@RequestBody Guarantor guarantor){

              return   this.guarantor.create(guarantor);
    }
}
