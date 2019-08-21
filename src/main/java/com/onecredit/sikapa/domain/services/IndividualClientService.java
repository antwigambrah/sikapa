package com.onecredit.sikapa.domain.services;

import com.onecredit.sikapa.domain.dto.IndividualClientDTO;
import com.onecredit.sikapa.domain.dto.IndividualClientMapper;
import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.IndividualClient;
import com.onecredit.sikapa.domain.entities.User;
import com.onecredit.sikapa.domain.repositories.BranchRepository;
import com.onecredit.sikapa.domain.repositories.IndividualClientRepository;

import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class IndividualClientService {
    private final IndividualClientRepository clientRepository;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final IndividualClientMapper clientMapper;
    private LocalDate dateofBirth;



    @Autowired
    public IndividualClientService(IndividualClientRepository clientRepository, UserRepository userRepository, BranchRepository branchRepository, IndividualClientMapper clientMapper) {
        this.clientRepository=clientRepository;
        this.userRepository=userRepository;
        this.branchRepository = branchRepository;
        this.clientMapper=clientMapper;
    }

    public List<IndividualClientDTO> all(){
        return    this.clientMapper.toIndividualClientDTOs(this.clientRepository.findAll());
    }


    public  IndividualClientDTO createClient(IndividualClient individualClient, String authenticatedUser) {
        dateofBirth= LocalDate.parse(individualClient.getDateOfBirth().toString());
        LocalDate currentDate =LocalDate.now();
        //TODO check out date and age
        long age=ChronoUnit.YEARS.between(currentDate,dateofBirth);

        User user=this.userRepository.findByUsername(authenticatedUser);
        Branch branch=this.branchRepository.findById(individualClient.getBranch().getId()).orElse(new Branch());
        individualClient.setDateOfBirth(dateofBirth);
        individualClient.setUser(user);
        individualClient.setAge((int)age);
        individualClient.setBranch(branch);


        this.clientRepository.save(individualClient);
            return this.clientMapper.toIndividualClientDTO(individualClient);
    }


    public IndividualClient findClientById(Long id) {
        return this.clientRepository.findById(id).orElse(new IndividualClient());
    }


}
