package com.onecredit.sikapa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @GetMapping(path = "/clients")
    public String index(){
        return "client";
    }

    @GetMapping(value = "/clients", params = "type")
    public String create(
                @RequestParam("type") String type) {

        return type.equals("individual")?"individualclient":"corporateclient";
    }
}
