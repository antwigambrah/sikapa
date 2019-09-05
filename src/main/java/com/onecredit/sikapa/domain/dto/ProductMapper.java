package com.onecredit.sikapa.domain.dto;

import com.onecredit.sikapa.domain.entities.Branch;
import com.onecredit.sikapa.domain.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> toProductDTOs(List<Product> products);

}
