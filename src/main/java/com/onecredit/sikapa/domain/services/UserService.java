package com.onecredit.sikapa.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.dto.UserMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Persistent
    SessionFactory sessionFactory;

    @Autowired
    public UserService(UserRepository userRepository, BranchRepository branchRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.branchRepository = branchRepository;

    }

    public List<UserDTO> all() {
        return this.userMapper.toUserDTOs(
                this.userRepository.findAll()
        );
    }

    public UserDTO createUser(String firstname, String middlename, String surname, String username, String role, Long branch) {

        Branch branchData = this.branchRepository.findById(branch).orElse(new Branch());
        User userData = new User(firstname, middlename, surname, username, passwordEncoder.encode(username), role, "");
        userData.setBranch(branchData);
        this.userRepository.save(userData);
        return this.userMapper.toUserDTO(userData);
    }

    public User findUserById(Long id) {
        return this.userRepository.findById(id)
                .orElse(new User());
    }


    public UserDTO findUserByName(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        return this.userMapper.toUserDTO(user);
    }

}