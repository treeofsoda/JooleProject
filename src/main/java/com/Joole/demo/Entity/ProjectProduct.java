package com.Joole.demo.Entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Project_Product")
@Table(name = "project_product")
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int prid;

    @ManyToOne (cascade = CascadeType.MERGE)
//    @MapsId("projectId")
    @JoinColumn(
            name = "project_id",
            referencedColumnName="project_id"
    )
    private Project project;

    @ManyToOne (cascade = CascadeType.MERGE)
//    @MapsId("resourceId")
    @JoinColumn(
            name = "resource_id",
            referencedColumnName="resource_id"
    )
    private Product product;

    //    @Column(
//            name = "time_created",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    @CreatedDate
    private LocalDateTime timeCreated;

    public ProjectProduct(int prid,
                          Project project,
                          Product product,
                          LocalDateTime timeCreated) {
        this.prid = prid;
        this.project = project;
        this.product = product;
        this.timeCreated = timeCreated;
    }

    public ProjectProduct(Project project,
                          Product product,
                          LocalDateTime timeCreated) {
        this.project = project;
        this.product = product;
        this.timeCreated = timeCreated;
    }

    public ProjectProduct(Project project, Product product) {
        this.project = project;
        this.product = product;
    }

    public ProjectProduct() {
    }

    public int getPRid() {
        return prid;
    }

    public void setPRid(int PRid) {
        this.prid = PRid;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getTime_created() {
        return timeCreated;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.timeCreated = time_created;
    }

    @Override
    public String toString() {
        String project_id = project == null ? null : Integer.toString(project.getProjectId());
        String product_id = product == null ? null : Integer.toString(product.getResourceId());
        return "ProjectProduct{" +
                "PRid = " + prid +
                " project_id = " + project_id +
                " resource_id = " + product_id + "}";
    }
}
