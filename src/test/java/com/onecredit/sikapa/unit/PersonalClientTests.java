package com.onecredit.sikapa.unit;
import com.onecredit.sikapa.domain.dto.IndividualClientMapper;
import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.IndividualClient;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.IndividualClientRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.IndividualClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonalClientTests {

    @Mock
    private IndividualClientRepository clientRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BranchRepository branchRepository;
    @Mock
    private IndividualClientService clientService;

    @Autowired
    private IndividualClientMapper clientMapper;

    private IndividualClient personalClient;

    private LocalDate dateofBirth;

    private Client client;


    @Before
    public void setUp(){
        clientService=new IndividualClientService(clientRepository,userRepository, branchRepository, clientMapper);
        dateofBirth = LocalDate.parse("2019/04/04",DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        this.client=new Client("0244706194","bingo@gmail.com",3,"Plot 83 BLock 23","Suame","P,O,BOX AS 509 ASAWASI","near akrobeto spot","AS-34-343","rented",3,"5512310001232323","afasdfasdfsadf");
        this.personalClient=new IndividualClient("kwame", "", "aban", "MALE", "SINGLE", dateofBirth, "kwaso", 23, "kwame danso", "GH", "teaching", client);
    }

    @Test
    public void creat_personal_client_is_successful(){
                given(clientRepository.findById(1L)).willReturn(java.util.Optional.of(this.personalClient));
                IndividualClient clientData=clientService.findClientById(1L);
                assertEquals(clientData.getFirstName(),"kwame");
    }

    @Test
    public void personal_client_gender_returns_string(){
        given(clientRepository.findById(1L)).willReturn(java.util.Optional.of(personalClient));
        IndividualClient clientData=clientService.findClientById(1L);
        assertEquals(clientData.getGender(),IndividualClient.Gender.MALE);
    }
}
