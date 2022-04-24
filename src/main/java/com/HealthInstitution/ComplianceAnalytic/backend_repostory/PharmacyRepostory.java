package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepostory extends JpaRepository<Pharmacy, Long> {
}
