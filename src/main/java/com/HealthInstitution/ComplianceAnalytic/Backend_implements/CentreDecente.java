package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Caraes;
import com.HealthInstitution.ComplianceAnalytic.backend_model.CentreDesanté;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.CentreDeSanteRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_services.CentreDeSanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CentreDecente implements CentreDeSanteService {
    @Autowired
    private CentreDeSanteRepostory centreDeSanteRepostory;

    @Override
    public void save(CentreDesanté caraes) {
        centreDeSanteRepostory.save(caraes);

    }

    @Override
    public void delete(CentreDesanté caraes) {
        centreDeSanteRepostory.delete(caraes);

    }

    @Override
    public List<CentreDesanté> findAll() {
        return centreDeSanteRepostory.findAll();
    }

    @Override
    public CentreDesanté findOne(long id) {
        return centreDeSanteRepostory.findById(id).get();
    }


}
