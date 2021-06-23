/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.controllers;

import com.pcedu.sboot.entities.Product;
import com.pcedu.sboot.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author George.Pasparakis
 */
@Controller("products")
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    @GetMapping("/")
    public String getAllProducts(Model model) { // http://localhost:8080/products/
        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return("products");
    }
    
    @GetMapping("/new")
    public String newProduct(Model model) { // http://localhost:8080/products/new
//        Product p = new Product(1L, "AAA", "Desc AAA", 100, "http://sdfsdf"); // Demonstration purposes
        Product p = new Product();
        model.addAttribute("product", p);
        return("newProduct");
    }
    
    @PostMapping("/new")
    public String insertProduct(@ModelAttribute(name="product")Product p, Model model) {
        if(service.insertProduct(p)) {
            List<Product> products = service.getAllProducts();
            model.addAttribute("products", products);
            return("products");
        } else {
            return("/");
        }
    }
    
}
