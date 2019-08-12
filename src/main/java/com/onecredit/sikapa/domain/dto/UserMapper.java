package com.onecredit.sikapa.domain.dto;

import java.util.List;
import com.onecredit.sikapa.domain.entities.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {
    UserDTO toUserDTO(User User);


    List<UserDTO> toUserDTOs(List<User> users);

}