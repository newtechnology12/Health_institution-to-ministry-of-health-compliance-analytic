package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.CaraesRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.CaraesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaraesImplement implements CaraesServices {
    @Autowired
    private final CaraesRepostory caraesRepostory;

@Autowired
    public CaraesImplement(CaraesRepostory caraesRepostory) {
        this.caraesRepostory = caraesRepostory;
    }

    @Override
    public void save(Caraes caraes) {
    caraesRepostory.save(caraes);

    }

    @Override
    public void delete(Caraes caraes) {
    caraesRepostory.delete(caraes);

    }

    @Override
    public List<Caraes> findAll() {
        return caraesRepostory.findAll();
    }

    @Override
    public Caraes findOne(long id) {
        return caraesRepostory.getById(id);
    }




}
