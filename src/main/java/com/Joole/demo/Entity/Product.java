package com.Joole.demo.Entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "product_sequence"
//    )
//
//    @Column(
//            name = "resource_id"
//    )
    private Long resource_id;

//    @Column(
//            name = "Model_year",
//            nullable = false
//    )


    private Long Model_year;

//    @Column(
//            name = "Brand",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
    private String Brand;

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
    private LocalDateTime time_created;

//    @Column(
//            name = "last_updated",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
    private LocalDateTime last_updated;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "product"
    )
    private List<ProjectProduct> project_products = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private TechnicalDetail technicalDetail;



    public Product(Long model_year, String brand,
                   String certification, LocalDateTime time_created,
                   LocalDateTime last_updated) {
        this.Model_year = model_year;
        this.Brand = brand;
        this.certification = certification;
        this.time_created = time_created;
        this.last_updated = last_updated;
    }

    public Product() {
    }


    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public TechnicalDetail getTechnicalDetail() {
        return technicalDetail;
    }

    public void setTechnicalDetail(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
    }

    public Long getModel_year() {
        return Model_year;
    }

    public void setModel_year(Long model_year) {
        Model_year = model_year;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
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

    public List<ProjectProduct> getProject_Product() {
        return project_products;
    }

    public void addProject_Product(ProjectProduct project_product) {
        if (!project_products.contains(project_product)) {
            project_products.add(project_product);
        }
    }

    public void removeProject_Product(ProjectProduct project_product) {
        project_products.remove(project_product);
    }

    @Override
    public String toString() {
        return "Product{" +
                "resource_id=" + resource_id +
                ", Model_year=" + Model_year +
                ", Brand='" + Brand + '\'' +
                ", certification='" + certification + '\'' +
                ", time_created=" + time_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
