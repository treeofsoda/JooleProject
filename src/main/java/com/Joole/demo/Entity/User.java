package com.Joole.demo.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
//    @SequenceGenerator(
//        name = "user_sequence",
//        sequenceName = "user_sequence",
//        allocationSize = 1
//    )
//    @GeneratedValue(
//        strategy = SEQUENCE,
//        generator = "user_sequence"
//    )


//    @Column(
//            name = "user_name",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
    private String user_name;

    @Column(
            name = "role"
//            nullable = false
    )
    private String role;

    @Column(
            name = "password",
//            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

//    @Column(
//            name = "time_created",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    @CreatedDate
    private LocalDateTime time_created;

//    @Column(
//            name = "last_updated",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    @LastModifiedDate
    private LocalDateTime last_updated;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "user"
    )
    private List<Project> projects = new ArrayList<>();

    public User(String user_name, String role,
                String password,
                LocalDateTime time_created,
                LocalDateTime last_updated) {
        this.user_name = user_name;
        this.role = role;
        this.password = password;
        this.time_created = time_created;
        this.last_updated = last_updated;
    }

    public User(String role, String password,
                LocalDateTime time_created,
                LocalDateTime last_updated) {

        this.role = role;
        this.password = password;
        this.time_created = time_created;
        this.last_updated = last_updated;
    }

    public User() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.time_created = time_created;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public List<Project> getProject() {
        return projects;
    }

    public void addProject(Project project){
        if(!this.projects.contains(project)){
            this.projects.add(project);
            project.setUser(this);
        }
    }

    public void removeProject(Project project){
        if(this.projects.contains(project))
            this.projects.remove(project);
            project.setUser(null);
    }


    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", time_created=" + time_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
