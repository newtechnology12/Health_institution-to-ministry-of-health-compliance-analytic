package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;

import java.util.List;

public interface PolyClinicServices {
    void save(Caraes caraes);
    void delete(Caraes caraes);
    List<Caraes> findAll();
    Caraes findOne(long id);
    Caraes findByCountryName(String name);
}
