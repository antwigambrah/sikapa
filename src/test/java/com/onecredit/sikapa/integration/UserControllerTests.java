package com.onecredit.sikapa.integration;


import com.onecredit.sikapa.api.UserController;
import com.onecredit.sikapa.domain.dto.UserDTO;
import com.onecredit.sikapa.domain.dto.UserMapper;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("de")
public class UserControllerTests {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @InjectMocks
    private UserController userController;


    @Before
    public void setup()throws  Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }



    @Test
     public void test_default_admin_is_registered() throws Exception {

         List<User> users= Arrays.asList(
                 new User("Antwi","","Gambrah","AGambrah","bingo123","USER",""),
                 new User("Antwi","","Gambrah","AGambrah","bingo123","admin","")
                );
        userRepository.saveAll(users);
        List<UserDTO>userDTO=userMapper.toUserDTOs(users);
        when(userService.all()).thenReturn(userDTO);
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].username").value("AGambrah"));

    }


    }
