package com.onecredit.sikapa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoanController {

    @GetMapping(path = "/loans")
    public String index(){
        return "loan";
    }

    @GetMapping(value = "/loans", params = "type")
    public String create(
            @RequestParam("type") String type) {

        return type.equals("individual")?"individualapplication":"corporateapplication";
    }
}
