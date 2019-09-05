package com.onecredit.sikapa.api;

import com.onecredit.sikapa.domain.entities.Product;
import com.onecredit.sikapa.domain.repositories.LoanProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class LoanProductController {

    private LoanProductRepository products;

    @Autowired
    public LoanProductController(LoanProductRepository products){

        this.products = products;
    }

    /**
     * Get  LoanProducts
     *
     * @return LoanProduct
     */
    @GetMapping(path = "/products")
    public List<Product> index(){
        return this.products.findAll();
    }


    /**
     * Create Product
     *
     * @param product Product
     * @return Product;
     */
    @PostMapping(path = "/products")
    public ResponseEntity<Product> create(@RequestBody Product product){
        this.products.save(product) ;
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
