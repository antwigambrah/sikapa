

package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.User;
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
    //TODO FIX STATUS RETURNING 0 INSTEAD OF 1
    private User.AccountStatus status;
    private  Branch branch;
    private String username;

}