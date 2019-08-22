package com.onecredit.sikapa.domain.entities;

public class LoanProduct {
    enum ProductStatus{
        IN_ACTIVE,
        ACTIVE
    }
    private String name;
    private ProductStatus Status;
}
