package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.services.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

//TODO CREATE ABSRTRACT USER SERVICE CLASS
@RestController
@RequestMapping(path = "/api")
public class AuthUserController {


    private AuthUserService auth;


    @Autowired
    public AuthUserController(AuthUserService  auth) {
        this.auth =  auth;
    }

    /**
     *Get Authenticated User
     *
     * @return Authenticated User
     */
    @GetMapping(path = "/auth/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO index(Authentication auth){
        return this.auth.findUserByName(auth.getName());

    }

    /**
     * Update User
     *
     * @param id User id
     * @param user USer
     * @return User
     */
    @PatchMapping(path="/auth/user/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@PathVariable(value = "id") Long id, @RequestBody User user){
        return this.auth.updateUser(id,user);
    }

}
