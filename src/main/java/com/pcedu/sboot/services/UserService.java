/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.services;

import com.pcedu.sboot.entities.User;
import com.pcedu.sboot.repositories.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author George.Pasparakis
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public User findByUserName(String username) {
        return(repository.findByUserName(username));
    }
}
