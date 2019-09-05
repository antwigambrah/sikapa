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

    /**
     * Update User
     *
     * @param id Id
     * @param user User
     * @return User
     */
    public UserDTO updateUser(Long id, User user){

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

    /**
     * Find User
     *
     * @param username User
     * @return User
     */
    public UserDTO findUserByName(String username) {
        User user = this.userRepository.findByUsername(username);
        return this.userMapper.toUserDTO(user);
    }
}
