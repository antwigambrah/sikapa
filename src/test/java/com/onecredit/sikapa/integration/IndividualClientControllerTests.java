package com.onecredit.sikapa.integration;

import com.onecredit.sikapa.api.IndividualClientController;
import com.onecredit.sikapa.domain.dto.IndividualClientMapper;
import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.IndividualClient;
import com.onecredit.sikapa.domain.repositories.IndividualClientRepository;
import com.onecredit.sikapa.domain.services.IndividualClientService;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class IndividualClientControllerTests {


    private MockMvc mockMvc;

    @Mock
    private IndividualClientService clientService;
    @Mock
    private IndividualClientRepository clientRepository;

    private IndividualClient personalClient;
    @Autowired
    private IndividualClientMapper clientMapper;
    @InjectMocks
    private IndividualClientController individualClientController;

    @Before
    public void setup()throws  Exception{

        mockMvc= MockMvcBuilders.standaloneSetup(individualClientController).build();


        LocalDate localStartDate = LocalDate.parse("04/04/2019",DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        Client client=new Client("0244706194","bingo@gmail.com",3,"Plot 83 BLock 23","Suame","P,O,BOX AS 509 ASAWASI","near akrobeto spot","AS-34-343","rented",3,"5512310001232323","3232323323232");
       this.personalClient=new IndividualClient("kwame", "", "aban", "MALE", "SINGLE",localStartDate, "kwaso", 23, "kwame danso", "GH", "teaching", client);
    }


    @Test
    public void should_return_success_when_client_is_created() throws Exception{
        this.clientRepository.save(this.personalClient);
         when(clientService.createClient(personalClient,"AGambrah")).thenReturn(this.clientMapper.toIndividualClientDTO(this.personalClient));
         mockMvc.perform(post("/api/client/personal",this.personalClient).contentType(MediaType.APPLICATION_JSON_UTF8))
                 .andDo(print());
    }


}
