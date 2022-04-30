package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepostory extends JpaRepository<Hospital, Long> {
}
