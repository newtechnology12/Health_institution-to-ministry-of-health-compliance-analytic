package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Clinique;

import java.util.List;

public interface CliniqueSeServices {
    void save(Clinique caraes);
    void delete(Clinique  caraes);
    List<Clinique> findAll();
    Clinique findOne(long id);

}
