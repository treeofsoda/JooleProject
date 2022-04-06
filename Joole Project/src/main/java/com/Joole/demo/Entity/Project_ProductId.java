package com.Joole.demo.Entity;

import javax.persistence.*;
import com.Joole.demo.Entity.Project_Product;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Project_ProductId implements Serializable {

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "resource_id")
    private Long resourceId;

    public Project_ProductId(Long projectId, Long resourceId) {
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public Project_ProductId() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProductId() {
        return resourceId;
    }

    public void setProductId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project_ProductId that = (Project_ProductId) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(resourceId, that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, resourceId);
    }
}
