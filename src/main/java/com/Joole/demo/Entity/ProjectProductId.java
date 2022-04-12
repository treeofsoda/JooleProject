package com.Joole.demo.Entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectProductId implements Serializable {

    @Column(name = "PRid")
    private int PRid;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "resource_id")
    private int resourceId;

    public ProjectProductId(int projectId, int resourceId) {
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public ProjectProductId() {
    }

    public int getPRid() {
        return PRid;
    }

    public void setPRid(int PRid) {
        this.PRid = PRid;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProductId() {
        return resourceId;
    }

    public void setProductId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectProductId that = (ProjectProductId) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(resourceId, that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, resourceId);
    }
}
