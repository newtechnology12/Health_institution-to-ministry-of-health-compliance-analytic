package com.HealthInstitution.ComplianceAnalytic.backend_repostory;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationRepostory extends JpaRepository<UserRegistration, Long> {
    @Query(value = "select * from users s where s.first_name like %:keyword% or s.last_name like %:keyword%", nativeQuery = true)
    List<Hospital> findByKeyword(@Param("keyword") String keyword);

}
