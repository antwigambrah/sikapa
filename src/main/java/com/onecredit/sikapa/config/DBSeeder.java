package com.onecredit.sikapa.config;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.UserService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class DBSeeder implements ApplicationRunner {

    private PasswordEncoder passwordEncoder;


    private UserRepository userRepository;

    private BranchRepository branchRepository;

    private Flyway flyway;

    @Autowired
     public DBSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder, BranchRepository branchRepository, Flyway flyway){
         this.passwordEncoder = passwordEncoder;
         this.userRepository=userRepository;
        this.branchRepository = branchRepository;
        this.flyway=flyway;
     }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.flyway.baseline();
        this.flyway.clean();
        this.flyway.migrate();
        Branch branch=new Branch("head-office","head-office");
        this.branchRepository.save(branch);
        String password=this.passwordEncoder.encode("bingo1234");
        User admin=new User("Admin","","Admin","admin",password,"ADMIN","");
        admin.setBranch(branch);
        this.userRepository.save(admin);
    }
}
