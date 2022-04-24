package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.DentalCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentalRepostory extends JpaRepository<DentalCenter, Long> {
}
