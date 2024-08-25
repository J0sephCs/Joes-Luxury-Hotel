package com.hotelapi.hotelapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest {

    
    @Id
    @Column(name = "guestid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer guestid;
    @Column(name = "firstname")
    public String firstname;
    @Column(name = "lastname")
    public String lastname;
    @Column(name= "email")
    public String email;
    @Column(name = "password")
    public String password;
    @Column(name= "phonenumber")
    public String phonenumber;


    public Guest(Integer guestid, String firstname, String lastname, String email, String password, String phonenumber){
        this.guestid= guestid;
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
        this.password= password;
        this.phonenumber= phonenumber;
    }
    public Guest(String firstname, String lastname, String email, String password, String phonenumber){
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
        this.password= password;
        this.phonenumber= phonenumber;
    }

  

    public Integer getGuestid(){
        return guestid;
    }
    public void setGuestId(Integer guestid){
        this.guestid= guestid;
    }

    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname= firstname;
    }

    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname= lastname;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber= phonenumber;
    }



}
