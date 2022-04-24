package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepostory extends JpaRepository<Laboratory, Long> {
}
