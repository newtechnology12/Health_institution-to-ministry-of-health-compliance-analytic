package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.UserRegistrationRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.UserRegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;
@Service
public class UserRegistrationImplemnt implements UserRegistrationServices {
    @Autowired
    private UserRegistrationRepostory userRegistrationRepostory;

    @Override
    public void save(UserRegistration userRegistration) {
        userRegistrationRepostory.save(userRegistration);
    }

    @Override
    public void delete(UserRegistration userRegistration) {
        userRegistrationRepostory.delete(userRegistration);
    }

    @Override
    public List<UserRegistration> findAll() {
        return userRegistrationRepostory.findAll();
    }

    @Override
    public UserRegistration findById(Long id) {
        return userRegistrationRepostory.getById(id);
    }


}
