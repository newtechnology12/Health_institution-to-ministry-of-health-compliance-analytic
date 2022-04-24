package com.HealthInstitution.ComplianceAnalytic.backend_services;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;

import java.util.List;

public interface HospitalServices  {
    void save(Hospital caraes);
    void delete(Hospital  caraes);
    List<Hospital > findAll();
    Hospital  findOne(long id);

}
