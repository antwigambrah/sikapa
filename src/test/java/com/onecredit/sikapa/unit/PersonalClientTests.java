package com.onecredit.sikapa.unit;

import com.onecredit.sikapa.domain.dto.PersonalClientMapper;
import com.onecredit.sikapa.domain.entities.Client;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import com.onecredit.sikapa.domain.repositories.PersonalClientRepository;
import com.onecredit.sikapa.domain.repositories.UserRepository;
import com.onecredit.sikapa.domain.services.PersonalClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonalClientTests {

    @Mock
    private PersonalClientRepository clientRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PersonalClientService clientService;

    @Autowired
    private PersonalClientMapper clientMapper;

    private PersonalClient personalClient;

    private Client client;


    @Before
    public void setUp(){

        clientService=new PersonalClientService(clientRepository,userRepository,clientMapper);
        Date dateofBirth=new Date(23/4/93);
        this.client=new Client("0244706194","bingo@gmail.com",3,"Plot 83 BLock 23","Suame","P,O,BOX AS 509 ASAWASI","near akrobeto spot","AS-34-343","rented",3,"5512310001232323");
        this.personalClient=new PersonalClient("kwame", "", "aban", "MALE", "SINGLE", dateofBirth, "kwaso", 23, "kwame danso", "GH", "teaching", client);
    }

    @Test
    public void creat_personal_client_is_successful(){
                given(clientRepository.findById(1L)).willReturn(java.util.Optional.of(this.personalClient));
                PersonalClient clientData=clientService.findClientById(1L);
                assertEquals(clientData.getFirstName(),"kwame");
    }

    @Test
    public void personal_client_gender_returns_string(){
        given(clientRepository.findById(1L)).willReturn(java.util.Optional.of(personalClient));
        PersonalClient clientData=clientService.findClientById(1L);
        assertEquals(clientData.getGender(),PersonalClient.Gender.MALE);
    }
}
