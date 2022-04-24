package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CaraesServices {
    void save(Caraes caraes);
    void delete(Caraes caraes);
    List<Caraes> findAll();
    Caraes findOne(long id);

}
