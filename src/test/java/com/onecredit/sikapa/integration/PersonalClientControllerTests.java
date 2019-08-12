package com.onecredit.sikapa.integration;

import com.onecredit.sikapa.api.PersonalClientController;
import com.onecredit.sikapa.domain.dto.PersonalClientMapper;
import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import com.onecredit.sikapa.domain.repositories.PersonalClientRepository;
import com.onecredit.sikapa.domain.services.PersonalClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PersonalClientControllerTests {


    private MockMvc mockMvc;

    @Mock
    private PersonalClientService clientService;
    @Mock
    private PersonalClientRepository clientRepository;

    private PersonalClient personalClient;

    @InjectMocks
    private PersonalClientController personalClientController;

    @Autowired
    private PersonalClientMapper clientMapper;

    @Before
    public void setup()throws  Exception{

        mockMvc= MockMvcBuilders.standaloneSetup(personalClientController).build();
       Date dateofBirth=new Date(23/4/93);
        Client client=new Client("0244706194","bingo@gmail.com",3,"Plot 83 BLock 23","Suame","P,O,BOX AS 509 ASAWASI","near akrobeto spot","AS-34-343","rented",3,"5512310001232323");
       this.personalClient=new PersonalClient("kwame", "", "aban", "MALE", "SINGLE", dateofBirth, "kwaso", 23, "kwame danso", "GH", "teaching", client);
    }


    @Test
    public void should_return_success_when_client_is_created() throws Exception{
        this.clientRepository.save(this.personalClient);
         when(clientService.createClient(personalClient,"AGambrah")).thenReturn(this.personalClient);
         mockMvc.perform(post("/api/client/personal",this.personalClient).contentType(MediaType.APPLICATION_JSON_UTF8))
                 .andDo(print());
    }


}
