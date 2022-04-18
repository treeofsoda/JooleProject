package com.Joole.demo.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int resourceId;

//    @Column(
//            name = "Model_year",
//            nullable = false
//    )


    private Long modelYear;

    //    @Column(
//            name = "Brand",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
    private String brand;

    //    @Column(
//            name = "certification",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
    private String certification;

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

    @OneToMany(
            cascade = {CascadeType.MERGE},
            mappedBy = "product"
    )
    private List<ProjectProduct> projectProducts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private TechnicalDetail technicalDetail;

    public Product() {
    }

    public Product(int resourceId) {
        this.resourceId = resourceId;
    }

    public Product(Long modelYear, String brand,
                   String certification, LocalDateTime timeCreated,
                   LocalDateTime lastUpdated) {
        this.modelYear = modelYear;
        this.brand = brand;
        this.certification = certification;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Long getModelYear() {
        return modelYear;
    }

    public void setModelYear(Long modelYear) {
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
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

    public List<ProjectProduct> getProjectProducts() {
        return projectProducts;
    }

    public void setProjectProducts(List<ProjectProduct> projectProducts) {
        this.projectProducts = projectProducts;
    }

    public TechnicalDetail getTechnicalDetail() {
        return technicalDetail;
    }

    public void setTechnicalDetail(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
    }

    public void addProject_Product(ProjectProduct project_product) {
        if (!projectProducts.contains(project_product)) {
            projectProducts.add(project_product);
        }
    }

    public void removeProject_Product(ProjectProduct project_product) {
        projectProducts.remove(project_product);
    }

    @Override
    public String toString() {
        return "Product{" +
                "resourceId=" + resourceId +
                ", Model_year=" + modelYear +
                ", Brand='" + brand + '\'' +
                ", certification='" + certification + '\'' +
                ", time_created=" + timeCreated +
                ", last_updated=" + lastUpdated +
                '}';
    }
}