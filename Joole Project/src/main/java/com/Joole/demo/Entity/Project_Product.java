package com.Joole.demo.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "Project_Product")
@Table(name = "project_product")
public class Project_Product {
    @EmbeddedId
    private Project_ProductId PRid;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(
                    name = "project_product_project_id_fk"
            )
    )
    private Project project;

    @ManyToOne
    @MapsId("resourceId")
    @JoinColumn(
            name = "resource_id",
            foreignKey = @ForeignKey(
                    name = "project_product_resource_id_fk"
            )
    )
    private Product product;


//    @Column(
//            name = "time_created",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    private LocalDateTime time_created;

    public Project_Product(Project_ProductId PRid,
                           Project project,
                           Product product,
                           LocalDateTime time_created) {
        this.PRid = PRid;
        this.project = project;
        this.product = product;
        this.time_created = time_created;
    }

    public Project_Product(Project project,
                           Product product,
                           LocalDateTime time_created) {
        this.project = project;
        this.product = product;
        this.time_created = time_created;
    }

    public Project_Product() {
    }

    public Project_ProductId getPRid() {
        return PRid;
    }

    public void setPRid(Project_ProductId PRid) {
        this.PRid = PRid;
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
        return time_created;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.time_created = time_created;
    }
}