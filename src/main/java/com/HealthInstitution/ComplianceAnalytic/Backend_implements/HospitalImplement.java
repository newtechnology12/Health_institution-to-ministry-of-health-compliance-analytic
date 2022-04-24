package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.HospitalRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HospitalImplement implements HospitalServices {
    @Autowired
    private HospitalRepostory hospitalRepostory;

    @Override
    public void save(Hospital caraes) {
        hospitalRepostory.save(caraes);

    }

    @Override
    public void delete(Hospital caraes) {
        hospitalRepostory.delete(caraes);

    }

    @Override
    public List<Hospital> findAll() {
        return hospitalRepostory.findAll();
    }

    @Override
    public Hospital findOne(long id) {
        return hospitalRepostory.findById(id).get();
    }
}
