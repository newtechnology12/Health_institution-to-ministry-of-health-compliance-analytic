package com.HealthInstitution.ComplianceAnalytic.backend_model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="user")
@DynamicUpdate(true)
public class Caraes {
    @Id
    private Long id;
    private String Requirement_name;
    private byte[] RequirementPic;

    public Caraes() {
    }

    public Caraes(Long id, String requirement_name, byte[] requirementPic) {
        this.id = id;
        Requirement_name = requirement_name;
        RequirementPic = requirementPic;
    }

    public Caraes(String requirement_name, byte[] requirementPic) {
        Requirement_name = requirement_name;
        RequirementPic = requirementPic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirement_name() {
        return Requirement_name;
    }

    public void setRequirement_name(String requirement_name) {
        Requirement_name = requirement_name;
    }

    public byte[] getRequirementPic() {
        return RequirementPic;
    }

    public void setRequirementPic(byte[] requirementPic) {
        RequirementPic = requirementPic;
    }

    @Override
    public String toString() {
        return "Caraes{" +
                "id=" + id +
                ", Requirement_name='" + Requirement_name + '\'' +
                ", RequirementPic=" + Arrays.toString(RequirementPic) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caraes caraes = (Caraes) o;
        return Objects.equals(id, caraes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
