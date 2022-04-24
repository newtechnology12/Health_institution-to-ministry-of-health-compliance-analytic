package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Clinique;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.ClinicRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.CliniqueSeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CliniqueImplement implements CliniqueSeServices {
    @Autowired
    private ClinicRepostory clinicRepostory;

    @Override
    public void save(Clinique caraes) {
        clinicRepostory.save(caraes);

    }

    @Override
    public void delete(Clinique caraes) {
        clinicRepostory.delete(caraes);

    }

    @Override
    public List<Clinique> findAll() {
        return clinicRepostory.findAll();
    }

    @Override
    public Clinique  findOne(long id) {
        return clinicRepostory.findById(id).get();
    }
}
