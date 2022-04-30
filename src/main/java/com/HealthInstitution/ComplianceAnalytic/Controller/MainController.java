package com.HealthInstitution.ComplianceAnalytic.Controller;

import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import com.HealthInstitution.ComplianceAnalytic.backend_services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @Autowired
    private UserRegistrationServices userRegistrationServices;
    @Autowired
    private HospitalServices hospitalServices;
    @Autowired
    private CaraesServices caraesServices;
    @Autowired
    private CentreDeSanteService centreDeSanteService;
    @Autowired
    private CliniqueSeServices cliniqueSeServices;
    @Autowired
    private DentalCenterServices dentalCenterServices;
    @Autowired
    private LaboratoryServices laboratoryServices;
    @Autowired
    private MedicalCenterServices medicalCenterServices;
    @Autowired
    private OpticalCervices opticalCervices;
    @Autowired
     private  PolyClinicServices polyClinicServices;
    Logger logger= LoggerFactory.getLogger(this.getClass());


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("UserRegistrationCount",userRegistrationServices.findAll().size());
        model.addAttribute("hospitalCount", hospitalServices.findAll().size());
        model.addAttribute("CaraesCount",caraesServices.findAll().size());
        model.addAttribute("ClinicCount",cliniqueSeServices.findAll().size());
        model.addAttribute("DentalCenterCount",dentalCenterServices.findAll().size());
        model.addAttribute("LabortoryCount",laboratoryServices.findAll().size());
        model.addAttribute("MedicalCenterCount",laboratoryServices.findAll().size());
        model.addAttribute("OpticalCount",opticalCervices.findAll().size());
        model.addAttribute("PolyClinicCount",polyClinicServices.findAll().size());
        List<Hospital> hospitals=hospitalServices.findAll();
        List<String> HosptNames = new ArrayList<>();
        for (Hospital hsp : hospitals){
            HosptNames.add(hsp.getRequirement_name());
        }
        List<Integer>UserNumber=new ArrayList<>();
        for (Hospital hsp : hospitals){
            UserNumber.add(hsp.getUserRegistrations().size());
        }

        model.addAttribute("Hospital",HosptNames);
        model.addAttribute("UserNumber",UserNumber);
        return "index";
    }



}
