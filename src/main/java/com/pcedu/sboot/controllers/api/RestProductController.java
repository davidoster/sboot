/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.controllers.api;

import com.pcedu.sboot.entities.Product;
import com.pcedu.sboot.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author George.Pasparakis
 */
@RestController
@RequestMapping("/api/products") // http://localhost:8080/api/products
public class RestProductController {
    
    @Autowired
    private ProductService service;
     
    @GetMapping("/")
    public List<Product> getAllProducts() { // http://localhost:8080/api/products/
        List<Product> products = service.getAllProducts();
        return(products);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProductsResponseEntity() { // http://localhost:8080/api/products/
        List<Product> products = service.getAllProducts();
        ResponseEntity respEntity = new ResponseEntity<>(products, HttpStatus.FOUND);
        return(respEntity);
    }
    
    @PostMapping("/new")
    public boolean insertProduct(@RequestBody Product p) {
        return service.insertProduct(p);
    }
    
}
