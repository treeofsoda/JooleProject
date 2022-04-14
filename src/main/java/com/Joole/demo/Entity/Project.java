package com.Joole.demo.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int projectId;

    //    @Column(
//            name = "time_created",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    @CreatedDate
    private LocalDateTime timeCreated;

    //    @Column(
//            name = "last_updated",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    @LastModifiedDate
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(
            name = "owner",
//            nullable = false,
            referencedColumnName = "user_name",
            foreignKey = @ForeignKey(
                    name = "user_project_fk"
            )
    )
    private User user;

    @OneToMany(
            cascade = {CascadeType.MERGE},
            mappedBy = "project"
    )
    private List<ProjectProduct> projectProducts = new ArrayList<>();

    public Project() {
    }

    public Project(int project_id) {
        this.projectId = project_id;
    }

    public Project(LocalDateTime time_created,
                   LocalDateTime last_updated) {
        this.timeCreated = time_created;
        this.lastUpdated = last_updated;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProject_Product(ProjectProduct projectProduct) {
        if (!this.projectProducts.contains(projectProduct)) {
            this.projectProducts.add(projectProduct);
            projectProduct.setProject(this);
        }
    }

    public void removeProject_Product(ProjectProduct projectProduct) {
        if (this.projectProducts.contains(projectProduct)) {
            this.projectProducts.remove(projectProduct);
            projectProduct.setProject(null);
        }
    }

    public List<ProjectProduct> getProject_Product() {
        return projectProducts;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + projectId +
                ", time_created=" + timeCreated +
                ", last_updated=" + lastUpdated +
                '}';
    }
}