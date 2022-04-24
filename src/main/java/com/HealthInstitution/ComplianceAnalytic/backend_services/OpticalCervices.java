package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;

import java.util.List;

public interface OpticalCervices {
    void save(Caraes caraes);
    void delete(Caraes caraes);
    List<Caraes> findAll();
    Caraes findOne(long id);
    Caraes findByCountryName(String name);

}
