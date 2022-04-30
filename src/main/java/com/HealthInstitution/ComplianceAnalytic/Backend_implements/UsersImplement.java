package com.HealthInstitution.ComplianceAnalytic.Backend_implements;

import com.HealthInstitution.ComplianceAnalytic.backend_model.HealphcareCategory;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.HospitalRepostory;
import com.HealthInstitution.ComplianceAnalytic.backend_repostory.UserRegistrationRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UsersImplement implements CommandLineRunner {
  private final UserRegistrationRepostory userRegistrationRepostory;
    private final HospitalRepostory hospitalRepostory;

    public UsersImplement(UserRegistrationRepostory userRegistrationRepostory, HospitalRepostory hospitalRepostory) {
        this.userRegistrationRepostory = userRegistrationRepostory;
        this.hospitalRepostory = hospitalRepostory;
    }

    @Override
    public void run(String... args) throws Exception {
        Hospital hospital = new Hospital(1L,"doctor",null);
        hospitalRepostory.save(hospital);
        UserRegistration user = new UserRegistration("sentongo","sentongo","Kigali", HealphcareCategory.HOSPITAL,LocalDate.of(1991,07,05),LocalDate.of(1995,07,05),"albert12","albert@gmail.com","magufuri",true);
        userRegistrationRepostory.save(user);

        System.out.println("the number of requirement is "+hospitalRepostory.count());
        System.out.println("the number of users is "+userRegistrationRepostory.count());



    }
}
