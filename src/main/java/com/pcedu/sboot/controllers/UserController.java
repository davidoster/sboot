/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.controllers;

import com.pcedu.sboot.entities.User;
import com.pcedu.sboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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
@Controller("users")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    
    @GetMapping("/register") 
    public String registerUser(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return("register");
    }
    
    @PostMapping("/register")
    public String saveRegisterUser(@ModelAttribute(name="user")User u) {
        // User u here works as a Data Transfer Object DTO where it holds the data from the form
        // and passes these data to the org.springframework.security.core.userdetails.User
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        String encodedPassword = bCryptPasswordEncoder.encode(u.getPassword());
	org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(u.getUsername(), encodedPassword, authorities);
	jdbcUserDetailsManager.createUser(user);
        return("redirect:/products/");
    }
}
