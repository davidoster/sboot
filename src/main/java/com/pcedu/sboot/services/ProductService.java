/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.services;

import com.pcedu.sboot.entities.Product;
import com.pcedu.sboot.entities.User;
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
    
    public boolean insertProduct(Product p) {
        return repository.save(p).getId() > 0;
    }
    
    public Product getById(Long id) {
        return(repository.findById(id).get());
    }
    
    public boolean findById(Long id) {
        return(repository.findById(id).get().getId() > 0 );
    }
    
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return(true);
    }
    
    public boolean updateProduct(Product p) {
        // findById p.getId()
        // change properties
        // save
        Product dbProduct = repository.findById(p.getId()).get();
//        dbProduct = p; // NOOOOOOOOOOOO YOU BREAK PERSISTENCE!!!!!
        dbProduct.setName(p.getName());
        dbProduct.setDescription(p.getDescription());
        dbProduct.setPrice(p.getPrice());
        dbProduct.setImage(p.getImage());
        repository.saveAndFlush(dbProduct);
        return true;
    }
    
    public boolean insertBoughtProductForUser(String username, Long id, String date) {
        Product dbProduct = repository.findById(id).get();
        // create a UserService, UserRepository
        // call User u = userService.getUserByUserName(username);
//        System.out.println("User: " + u.toString());
//        dbProduct.getUsers().add(u);
        
        return true;
    }
    
}
