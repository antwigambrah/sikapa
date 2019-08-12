

package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;

/**
 * UserDTO
 */
@Transactional
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String roles;
    private String permissions;
    private int active;
    private  Branch branch;
    private String username;

}