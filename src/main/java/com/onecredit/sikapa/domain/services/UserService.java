package com.onecredit.sikapa.domain.services;

import java.util.List;
import javax.transaction.Transactional;
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

/**
 * UserService
 */
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, BranchRepository branchRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.userMapper = userMapper;
        this.passwordEncoder=passwordEncoder;
    }

    public List<UserDTO> all() {
        return this.userMapper.toUserDTOs(
                this.userRepository.findAll()
        );
    }

    public UserDTO createUser(User user) {
        String username=user.getFirstname().toUpperCase().charAt(0) + user.getSurname()  ;
        Branch branch = this.branchRepository.findById(user.getBranch().getId()).orElse(new Branch());
        user.setBranch(branch);
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode(username));

        this.userRepository.save(user);

        return this.userMapper.toUserDTO(user);
    }

    public UserDTO updateUser(Long id,User user){
        // TODO CREATE A CUSTOM EXCEPTION TO HANDLE DATA NOT FOUND
        //TODO DO SOMETHING ABOUT THE IF STATEMENTS
            User user1=this.userRepository.findById(id).orElse(new User());

        if (user.getRoles()!=null){
            user1.setRoles(user.getRoles());
        }
        if (user.getBranch()!=null)
        {

            Branch branch = this.branchRepository.findById(user.getBranch().getId()).orElse(new Branch());
            user1.setBranch(branch);
        }
        this.userRepository.save(user1);

            return this.userMapper.toUserDTO(user1);
    }


    public void deleteUser(Long id){
        User user=this.userRepository.findById(id).orElse(new User());
        this.userRepository.delete(user);
    }


    public UserDTO findUserById(Long id) {
        User user=this.userRepository.findById(id)
                .orElse(new User());
        return this.userMapper.toUserDTO(user);
    }

}