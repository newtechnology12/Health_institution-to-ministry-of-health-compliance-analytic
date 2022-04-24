package com.HealthInstitution.ComplianceAnalytic.backend_services;

import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;

public interface AssignedRequirementsService {
    void saveAssignedRequirement(UserRegistration userRegistration);
}
