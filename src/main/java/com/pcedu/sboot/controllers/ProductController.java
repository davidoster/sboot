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
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("title", "New Product");
        model.addAttribute("h1", "Insert New Product");
        model.addAttribute("submit", "Add a New Product");
        model.addAttribute("action", "/products/new");
        return("newEditProduct");
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
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id, Model model) {
        // 1. findById
        // 2. delete
        // 3. findAll
        if(service.findById(id)) {
            service.deleteById(id);
            List<Product> products = service.getAllProducts();
            model.addAttribute("products", products);
            return("products");
        } else {
            // forward /products
            return("redirect:/products/");
        }
        
    }
    
    // GET edit
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable(name="id") Long id, Model model) {
        // findById
        // addAttribute
        // forward /edit
        Product p = service.getById(id);
        model.addAttribute("product", p);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("h1", "Edit Product");
        model.addAttribute("action", "/products/update");
        model.addAttribute("submit", "Update Product");
        return("newEditProduct");
    }
    
    // GET or POST????
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute(name="product")Product p, Model model) {
        service.updateProduct(p);
        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return("products");
    }
}
