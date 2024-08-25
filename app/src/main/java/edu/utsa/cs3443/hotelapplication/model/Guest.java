package edu.utsa.cs3443.hotelapplication.model;

public class Guest {
    public String firstname, lastname, email, phonenumber, password;

    public Guest(String firstname, String lastname, String email, String phonenumber, String password){
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
        this.phonenumber= phonenumber;
        this.password= password;
    }

    public Guest(){

    }

    public Guest(String firstname, String lastname, String email) {
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
