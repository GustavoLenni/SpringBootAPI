package com.model;

import jakarta.persistence.*;

// the Entity is an annotation telling to JPA
// this class (User) represents a database
// Entity class is a class represents a database
@Entity
@Table(name = "users")
public class User {

    // I set my variable Id is an Id in my database and the
    // generation of value of my ID is auto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;

    public User(){

    }
    public User(Integer id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }


    // Get Functions
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    // Set Functions
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
