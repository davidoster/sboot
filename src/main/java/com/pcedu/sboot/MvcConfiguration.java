/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author George.Pasparakis
 */

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/").setViewName("home"); 
       registry.addViewController("/home").setViewName("home");
       registry.addViewController("/products/").setViewName("products");
    }
}
