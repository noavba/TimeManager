package com.example.timemanager.user;

import com.example.timemanager.roles.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Integer hoursGoal;

    public User(){}


    public User(String firstName, String userName, String email, String password, Integer hoursGoal, Enum Role) {

        this.firstName = firstName;
        this.username = userName;
        this.email = email;
        this.password = password;
        this.hoursGoal = hoursGoal;
        // KEEP WORKING ON HOURS GOALO

    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
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
    public String getUsername() {
        return username;
    }
    //this sets the username
    public void setUsername(String username) {
        this.username = username;
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

    public Integer getHoursGoal(){
        return hoursGoal;
    }
    public void setHoursGoal(Integer hoursGoal){
        this.hoursGoal = hoursGoal;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(hoursGoal, user.hoursGoal);
    }

    // hashCode method override
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, username, email, password, hoursGoal);
    }


    public void setRoles(Set<Role> roles){
        this.roles=roles;
    }

}