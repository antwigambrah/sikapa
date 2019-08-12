package com.onecredit.sikapa.api;

import java.util.List;
import java.util.Map;

import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/user",produces = "application/json")
    public UserDTO index(Authentication auth){

        return this.userService.findUserByName(auth.getName());

    }
    @GetMapping(path = "/users",produces = "application/json")
    public ResponseEntity<List<UserDTO>>getAll() {
        return ResponseEntity.ok(this.userService.all());
    }

    @PostMapping(path = "/users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDTO create(@RequestBody Map<String ,String>user) {

        return this.userService.createUser(
                user.get("firstname"),
                user.get("middlename"),
                user.get("lastname"),
                user.get("username"),
                user.get("role"),
                Long.parseLong(user.get("branch"))
        );
    }




}
