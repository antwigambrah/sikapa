package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.PersonalClient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonalClientMapper {
    PersonalClientDTO toPersonalClientDTO(PersonalClient client);

    List<PersonalClientDTO> toPersonalClientDTOs(List<PersonalClient> clients);

}
