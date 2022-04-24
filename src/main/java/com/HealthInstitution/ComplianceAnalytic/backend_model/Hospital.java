package com.HealthInstitution.ComplianceAnalytic.backend_model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="user")
@DynamicUpdate(true)
public class Hospital {
    @Id
    private Long id;
    private String Requirement_name;
    private byte[] RequirementPic;
    @ManyToMany(mappedBy = "hospitals",fetch = FetchType.EAGER)
    private Set<UserRegistration> userRegistrations = new HashSet<>();

    public Hospital() {
    }

    public Hospital(Long id, String requirement_name, byte[] requirementPic) {
        this.id = id;
        Requirement_name = requirement_name;
        RequirementPic = requirementPic;
    }

    public Hospital(String requirement_name, byte[] requirementPic) {
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

    public Set<UserRegistration> getUserRegistrations() {
        return userRegistrations;
    }

    public void setUserRegistrations(Set<UserRegistration> userRegistrations) {
        this.userRegistrations = userRegistrations;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", Requirement_name='" + Requirement_name + '\'' +
                ", RequirementPic=" + Arrays.toString(RequirementPic) +
                ", userRegistrations=" + userRegistrations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(id, hospital.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
