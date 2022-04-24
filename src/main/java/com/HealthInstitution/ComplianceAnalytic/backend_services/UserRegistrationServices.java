package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;

import java.util.List;

public interface UserRegistrationServices {
    void save(UserRegistration userRegistration);
    void delete(UserRegistration  userRegistration);
    List<UserRegistration> findAll();
    UserRegistration findById(Long id);

}
