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
    
    @Autowired
    private UserService userService;
    
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
        User u = userService.findByUserName(username);
        System.out.println("User: " + u.toString());
//        dbProduct.getUsers().add(u); // this line doesn't add the Order!!!!
       
        // CAUTION: The below line doesn't add date on the table Orders
        // The fact that we don't put a date on the order creates an error, since we put that dateofpurchase is NOT NULL
        // Since we don't have an Order entity we had to change the table structure from DATE to DATETIME
        // By doing this we can insert a DEFAULT value CURRENT_TIMESTAMP (check the structure of the Orders table)
        // so a current date time is inserted when the order is created!!!
        u.getProducts().add(dbProduct); // but this WORKS!!!!
        // if we need to add a record on the table in the middle of Orders we need to create an addtion from the table where
        // the JoinTable exists!!!!
        
        return true;
    }
    
}
