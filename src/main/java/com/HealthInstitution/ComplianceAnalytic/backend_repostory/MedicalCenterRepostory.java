package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.MedicalCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCenterRepostory extends JpaRepository<MedicalCenter, Long> {
}
