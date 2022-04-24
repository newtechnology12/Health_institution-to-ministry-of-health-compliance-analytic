package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.CentreDesanté;

import java.util.List;

public interface CentreDeSanteService {
    void save(CentreDesanté caraes);
    void delete(CentreDesanté caraes);
    List<CentreDesanté> findAll();
    CentreDesanté findOne(long id);

}
