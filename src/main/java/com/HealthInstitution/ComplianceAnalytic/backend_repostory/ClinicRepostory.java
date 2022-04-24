package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepostory extends JpaRepository<Clinique, Long> {
}
