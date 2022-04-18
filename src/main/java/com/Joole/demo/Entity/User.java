package com.Joole.demo.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User implements Serializable {



    @Id
    @GeneratedValue
    private Integer userId;

    @Column(name = "username", unique = true, nullable = false,length = 256)
    private String username;


    @Column(name = "password")
    private String password;


    @CreatedDate
    private LocalDateTime timeCreate;

    @LastModifiedDate
    private LocalDateTime lastUpdated;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

//    @Transient
//    private String token;

    public LocalDateTime getTimeCreate() {
        return timeCreate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }

    public Role getRole() {
        return role;
    }

//    public String getToken() {
//        return token;
//    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public User()
    {

    }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTimeCreate(LocalDateTime timeCreate) {
        this.timeCreate = timeCreate;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", time_created=" + timeCreate +
                ", last_updated=" + lastUpdated +
                '}';
    }
}
