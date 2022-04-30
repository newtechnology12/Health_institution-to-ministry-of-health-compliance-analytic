package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.UserRegistrationRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.AssignedRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignedRequirementImplement implements AssignedRequirementsService {
    @Autowired
    private UserRegistrationRepostory userRegistrationRepostory;
    @Override
    public void saveAssignedRequirement(UserRegistration userRegistration) {
        userRegistrationRepostory.save(userRegistration);

    }
}
