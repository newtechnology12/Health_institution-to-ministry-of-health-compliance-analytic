package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.CentreDesanté;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentreDeSanteRepostory extends JpaRepository<CentreDesanté, Long> {
}
