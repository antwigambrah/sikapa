package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.IndividualClient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IndividualClientMapper {
    IndividualClientDTO toIndividualClientDTO(IndividualClient client);

    List<IndividualClientDTO> toIndividualClientDTOs(List<IndividualClient> clients);

}
