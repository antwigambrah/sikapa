package com.onecredit.sikapa.unit;


import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.dto.UserMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.UserService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("prod")
public class UserTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BranchRepository branchRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private PasswordEncoder encoder;

    private User user;

    private Branch branch;


    @Before
    public  void setUp(){

        userService=new UserService(userRepository, branchRepository, userMapper,encoder);
        this.user= new User("Antwi","","Gambrah","AGambrah","bingo1234","USER","");

        this.branch=new Branch("suame","ashanti");

    }

    @Test
    public void createUserTest(){
        given(userRepository.findById(1L)).willReturn(java.util.Optional.of(this.user));
             User userData =userRepository.findById(1L).orElse(new User());
          assertEquals(userData.getUsername(),"AGambrah");
    }

    @Test
    public void user_account_status_returns_integer(){
        this.user.setBranch(branch);
        given(userRepository.findById(1L)).willReturn(java.util.Optional.of(user));
        User userData =userRepository.findById(1L).orElse(new User());
        assertEquals(userData.getStatus(), User.AccountStatus.ACTIVE);
    }
}
