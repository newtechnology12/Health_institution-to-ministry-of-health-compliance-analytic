package com.HealthInstitution.ComplianceAnalytic.backend_model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@DynamicUpdate(true)
public class Optical {
    @Id
    private Long id;
    private String Requirement_name;
    private byte[] RequirementPic;
}
