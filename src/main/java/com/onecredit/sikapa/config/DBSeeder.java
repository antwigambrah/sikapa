package com.onecredit.sikapa.config;

import com.onecredit.sikapa.domain.entities.PersonalClient;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.PersonalClientRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private PersonalClientRepository personalClientRepository;
    private BranchRepository branchRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
     public DBSeeder(UserRepository userRepository,PasswordEncoder passwordEncoder){
         this.userRepository=userRepository;
         this.passwordEncoder = passwordEncoder;
     }
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        // Create users
        User kofi = new User("Antwi","","Gambrah","AGambrah",passwordEncoder.encode("bingo123"),"ADMIN","");
        kofi.setId(1L);

        // Save to db
        this.userRepository.save(kofi);

    }
}
