package com.example.timemanager.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String userName;
    private String email;
    private String password;

    public User(){}


    public User(String firstName, String userName, String email, String password) {

        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
        this.password = password;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //this gets the username
    public String getUserName() {
        return userName;
    }
    //this sets the username
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //this gets the email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    // hashCode method override
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, userName, email, password);
    }
}