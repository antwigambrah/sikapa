package com.onecredit.sikapa.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private double maximumAmount;
    private double minimumAmount;
}
