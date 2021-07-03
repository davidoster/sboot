/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  George.Pasparakis
 * Created: Jul 3, 2021
 */

create table if not exists users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table if not exists authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled) values('admin','admin',true);
insert into authorities(username,authority) values('admin','ADMIN');

insert into users(username, password, enabled) values('user','password',true);
insert into authorities(username,authority) values('user','USER');

