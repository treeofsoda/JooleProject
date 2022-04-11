package com.Joole.demo.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
//    @SequenceGenerator(
//            name = "project_sequence",
//            sequenceName = "project_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "project_sequence"
//    )
//    @Column(
//            name = "project_id",
//            updatable = false
//    )
    private int project_id;

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
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "project"
    )
    private List<ProjectProduct> project_products = new ArrayList<>();

    public Project() {
    }

    public Project(int project_id) {
        this.project_id = project_id;
    }

    public Project(LocalDateTime time_created,
                   LocalDateTime last_updated) {
        this.time_created = time_created;
        this.last_updated = last_updated;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void addProject_Product(ProjectProduct project_product) {
        if (!this.project_products.contains(project_product)) {
            this.project_products.add(project_product);
            project_product.setProject(this);
        }
    }

    public void removeProject_Product(ProjectProduct project_product) {
        if (this.project_products.contains(project_product)) {
            this.project_products.remove(project_product);
            project_product.setProject(null);
        }
    }

    public List<ProjectProduct> getProject_Product() {
        return project_products;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", time_created=" + time_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
