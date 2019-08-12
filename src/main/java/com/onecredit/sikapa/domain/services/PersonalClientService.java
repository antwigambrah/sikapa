package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.PersonalClientDTO;
import com.onecredit.sikapa.domain.dto.PersonalClientMapper;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.PersonalClientRepository;

import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PersonalClientService {
    private final PersonalClientRepository clientRepository;
    private final UserRepository userRepository;
    private final PersonalClientMapper clientMapper;
    private  Date dateofBirth;



    @Autowired
    public PersonalClientService(PersonalClientRepository clientRepository,UserRepository userRepository,PersonalClientMapper clientMapper) {
        this.clientRepository=clientRepository;
        this.userRepository=userRepository;
        this.clientMapper=clientMapper;
    }

    public List<PersonalClientDTO> all(){
        return    this.clientMapper.toPersonalClientDTOs(this.clientRepository.findAll());
    }


    public  PersonalClient createClient( PersonalClient personalclient,String authenticatedUser) {
        try {
         dateofBirth=new SimpleDateFormat().parse(personalclient.getDateOfBirth().toString());
        }catch (ParseException ex){

        }

        User user=this.userRepository.findByUsername(authenticatedUser);
        personalclient.setDateOfBirth(dateofBirth);
        personalclient.setUser(user);

            return this.clientRepository.save(personalclient);
    }


    public PersonalClient findClientById(Long id) {
        return this.clientRepository.findById(id).orElse(new PersonalClient());
    }


}
