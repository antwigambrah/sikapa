package com.onecredit.sikapa.unit;


import com.onecredit.sikapa.domain.dto.UserMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.UserService;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BranchRepository branchRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;


    @Before
    public  void setUp(){

        userService=new UserService(userRepository,branchRepository,userMapper);

    }

    @Test
    public void createUserTest(){

        User user= new User("Antwi","","Gambrah","AGambrah","bingo1234","USER","");

        Branch branch=new Branch("suame","ashanti");
        user.setBranch(branch);
        given(userRepository.findById(1L)).willReturn(java.util.Optional.of(user));
             User userData =userService.findUserById(1L);
          assertEquals(userData.getUsername(),"AGambrah");
    }

    @Test
    public void user_account_status_returns_integer(){

        User user= new User("Antwi","","Gambrah","AGambrah","bingo1234","USER","");

        Branch branch=new Branch("suame","ashanti");
        user.setBranch(branch);
        given(userRepository.findById(1L)).willReturn(java.util.Optional.of(user));
        User userData =userService.findUserById(1L);
        assertEquals(userData.getStatus(), User.AccountStatus.ACTIVE);
    }
}
