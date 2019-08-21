package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.dto.UserMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthUserService(UserRepository userRepository,UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder=passwordEncoder;
    }
    public UserDTO updateUser(Long id, User user){
        // TODO CREATE A CUSTOM EXCEPTION TO HANDLE DATA NOT FOUND
        //TODO DO SOMETHING ABOUT THE IF STATEMENTS
        //TODO MAKE UPATED USER LOGOUT THEN CONTINUE
        User user1=this.userRepository.findById(id).orElse(new User());
        if (user.getUsername() != null) {
            user1.setUsername(user.getUsername());
        }
        if(user.getPassword()!=null) {
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        this.userRepository.save(user1);

        return this.userMapper.toUserDTO(user1);
    }


    public UserDTO findUserByName(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        return this.userMapper.toUserDTO(user);
    }
}
