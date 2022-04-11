package com.Joole.demo.Entity;

import javax.persistence.*;

@Entity(name = "technical_detail")
@Table(name = "technical_detail")
public class TechnicalDetail {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "technical_detail_id",
            referencedColumnName = "technical_detail_id",
            foreignKey = @ForeignKey(
                    name = "technical_detail_fk"
            )
    )
    private Product product;

    public TechnicalDetail() {
    }

    public TechnicalDetail(Long id, Product product) {
        this.id = id;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
