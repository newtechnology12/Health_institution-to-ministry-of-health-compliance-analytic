//package com.HealthInstitution.ComplianceAnalytic.Controller;
//
//import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
//import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
//import com.HealthInstitution.ComplianceAnalytic.backend_services.AssignedRequirementsService;
//import com.HealthInstitution.ComplianceAnalytic.backend_services.HospitalServices;
//import com.HealthInstitution.ComplianceAnalytic.backend_services.UserRegistrationServices;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//public class HospitalController {
//    @Autowired
//    private HospitalServices hospitalServices;
//    @Autowired
//    private UserRegistrationServices userRegistrationServices;
//    @Autowired
//    private AssignedRequirementsService assignedRequirementsService;
//    Logger log= LoggerFactory.getLogger(
//            this.getClass()
//    );
//
//
//
//    //	List all Hospital
//    @RequestMapping("/hospital")
//    public String listHospital(Model model) {
//        model.addAttribute("hospital", hospitalServices.findAll());
//        return "students/studentsList";
//    }
//
//    //	add student
//    @RequestMapping("/hospitalForm")
//    public String createHospitalForm(Model model) {
//        // created student object to hold student form data
//        Hospital hospital = new Hospital();
//        model.addAttribute("student", hospital);
//
//        return "students/students";
//    }
//
//    //	save student
//    @PostMapping("/save/hospital/new")
//    public String saveHospital(@Valid @ModelAttribute("hospital") Hospital hospital, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "students/studentForm";
//        }
//        else {
//           hospitalServices.save(hospital);
//            return "redirect:/addStudentCourses/{id}";
//        }
//    }
//
//    //	update student from page
//    @GetMapping("/hospital/edit/{id}")
//    public ModelAndView Desplayhospital(@PathVariable(value = "id") Long id, Model model) {
//        ModelAndView modelAndView = new ModelAndView("students/studentForm");
//        Hospital existingHospital =hospitalServices.findOne(id);
//        modelAndView.addObject("student", existingHospital);
//        return modelAndView;
//
//    }
//    @GetMapping("/addUserHospitalRequirement/{id}")
//    public String showStudentCourses(@PathVariable(value = "id") Long id, Model model){
//        try {
//            UserRegistration std = userRegistrationServices.findById(id);
//            List<Hospital> cr=hospitalServices.findAll();
//            model.addAttribute("hospital",cr);
//            model.addAttribute("userRegistration",std);
//        }catch(Exception ex){
//            log.error("An error just occured while displaying the AssignedRequirements"+ex);
//        }
//        return "Student_Course";
//    }
//    @PostMapping("/saveAssignedRequirement")
//    public String saveUser(@ModelAttribute("user") UserRegistration userRegistration) {
//        // save User to database
//        System.out.println("USER searched "+ userRegistration.getHospitals().size());
//        UserRegistration st1 = userRegistrationServices.findById(userRegistration.getId());
//        Set<Hospital> selectedHospitalRequirement = userRegistration.getHospitals();
//        Set<Hospital> existingHotelRequirement = new HashSet<>();
//        existingHotelRequirement = st1.getHospitals();
//        Set<Hospital> allHotelRequirement = new HashSet<>();
//        allHotelRequirement .addAll(existingHotelRequirement);
//        allHotelRequirement .addAll(selectedHospitalRequirement);
//        userRegistration.setHospitals(allHotelRequirement);
//        try {
//            assignedRequirementsService.saveAssignedRequirement(userRegistration);
//        }catch (Exception ex){
//            ex.printStackTrace();
//            log.error("An Error Occured while saving the Assigned Hospital Requirements"+ex);
//        }
//        return "redirect:/students";
//
//    }
//
//    @GetMapping("/check-User-hospitalRequirement/{id}")
//    public String checkSelectedRequirement(@PathVariable(value = "id") Long id, Model model) {
//        //get user from service
//        UserRegistration userRegistration = userRegistrationServices.findById(id);
//        // set User as model attribute to pre-populate the form
//        model.addAttribute("user", userRegistration);
//        // get list of selected Requirement;
//        Set<Hospital>hospitals = userRegistration.getHospitals();
//        model.addAttribute("hospital",hospitals);
//        return "selectedCourses";
//
//    }
//
//
//}
