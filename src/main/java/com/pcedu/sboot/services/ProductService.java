/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.services;

import com.pcedu.sboot.entities.Product;
import com.pcedu.sboot.repositories.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author George.Pasparakis
 */
@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository repository;
    
    public List<Product> getAllProducts() {

        // call from Repository findAllProducts / getAllProducts
        return repository.findAll();
        
    }
    
}
