/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.sboot.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 * @author George.Pasparakis
 */
@Configuration
@EnableWebSecurity
public class WebMvcConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
    
    // Enable JDBC Authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http -> authorize -> in what url -> what authorization
        http.authorizeRequests().antMatchers("/", "/home").permitAll(). //. // public - unregistered role
        antMatchers("/api/**").hasRole("ADMIN"). // registered - authenticated - role ADMIN
        antMatchers("/products/**").hasRole("USER").and(). // registered - authenticated - ROLE USER        
        formLogin().permitAll().and().logout().permitAll();
        
        http.csrf().disable();
    }
    
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
//    }
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user
//                = User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//        
//        UserDetails user2
//                = User.withDefaultPasswordEncoder()
//                        .username("user2")
//                        .password("password2")
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user, user2);
//    }
}
