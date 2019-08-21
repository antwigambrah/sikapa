package com.onecredit.sikapa.api;

import java.util.List;
import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



    /**
     *  Create User
     *
     * @param user User
     * @return User
     */

    //TODO add resource location in header
    @PostMapping(path = "users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDTO create(@RequestBody User user) {
//        response.addHeader("Location", String.valueOf(request.getRequestURL().append("/").append(userDTO.getId().toString())));
        return this.userService.createUser(user);
    }


    /**
     * Update User
     *
     * @param id User id
     * @param user USer
     * @return User
     */
    @PatchMapping(path="/users/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@PathVariable(value = "id") Long id,@RequestBody User user){
        return this.userService.updateUser(id,user);
    }

    /**
     * Find User
     *
     * @param id User id
     * @return User
     */
    @GetMapping(path="/users/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO find(@PathVariable(value = "id") Long id){
        return this.userService.findUserById(id);
    }


    /**
     * Delete User
     *
     * @param id User
     * @return User
     */
    @RequestMapping(path = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>delete (@PathVariable(value="id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    /**
     * Retrieve Users
     *
     * @return Users
     */
    @GetMapping(path = "/users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>>all() {
        return ResponseEntity.ok(this.userService.all());
    }


}
