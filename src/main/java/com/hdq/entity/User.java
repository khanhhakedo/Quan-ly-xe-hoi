package com.hdq.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

//    Khoa chinh
    @Id
    private String userName;

    private String userFirstName;
    private String userLastName;
    private String email;
    private String userPassword;
    private String phone;
    private String address;



}
