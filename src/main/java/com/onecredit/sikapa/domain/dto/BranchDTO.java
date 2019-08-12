package com.onecredit.sikapa.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;

@Transactional
@Getter
@Setter
public class BranchDTO {
    private Long id;
    private String area;
    private String region;
}
