package com.HealthInstitution.ComplianceAnalytic.Controller;

import com.HealthInstitution.ComplianceAnalytic.backend_model.HealphcareCategory;
import com.HealthInstitution.ComplianceAnalytic.backend_model.Hospital;
import com.HealthInstitution.ComplianceAnalytic.backend_model.UserRegistration;
import com.HealthInstitution.ComplianceAnalytic.backend_services.AssignedRequirementsService;
import com.HealthInstitution.ComplianceAnalytic.backend_services.HospitalServices;
import com.HealthInstitution.ComplianceAnalytic.backend_services.UserRegistrationServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserRegistrationContrall {
    @Autowired
    private UserRegistrationServices userRegistrationServices;
    @Autowired
    private HospitalServices hospitalServices;
    @Autowired
    private AssignedRequirementsService assignedRequirementsService;
    Logger log= LoggerFactory.getLogger(
            this.getClass()
    );


    //	List all users
    @RequestMapping("/usersList")
    public String listStudents(Model model) {
        model.addAttribute("users", userRegistrationServices.findAll());
        model.addAttribute("hospital", hospitalServices.findAll());
        model.addAttribute("healphcareCategory", HealphcareCategory.values());

        return "pages/examples/login";
    }

    //	add users
    @RequestMapping("/displayUserForm")
    public String createUserForm(Model model) {
        // created User object to hold user form data
        UserRegistration userRegistration = new UserRegistration();
        model.addAttribute("users", userRegistration);
        model.addAttribute("healphcareCategory", HealphcareCategory.values());
        model.addAttribute("hospital", hospitalServices.findAll());

        return "usersForm";
    }

    //	save users
    @PostMapping("/save/newUsers")
    public String saveUser(@Valid @ModelAttribute("user") UserRegistration  userRegistration, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "usersForm";
        }
        else {
            userRegistrationServices.save(userRegistration);
            return "redirect:/users";
        }
    }

    //	update users from page
    @GetMapping("/users/edit/{id}")
    public ModelAndView DesplayStudent(@PathVariable(value = "id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("users");
        model.addAttribute("hospital", hospitalServices.findAll());
        model.addAttribute("healphcareCategory", HealphcareCategory.values());
        UserRegistration existingUser = userRegistrationServices.findById(id);
        modelAndView.addObject("users", existingUser);
        return modelAndView;

    }

    @GetMapping("/addRequirementToUser/{id}")
    public String showUserRequirement(@PathVariable(value = "id") long id, Model model){
        try {
            UserRegistration userRegistration = userRegistrationServices.findById(id);
            List<Hospital> cr=hospitalServices.findAll();
            model.addAttribute("hospital",cr);
            model.addAttribute("user",userRegistration);
        }catch(Exception ex){
            log.error("An error just occured while displaying the Assigned Requirements"+ex);
        }
        return "User_requirement";
    }
    @PostMapping("/saveAssignedRequirement")
    public String saveUser(@ModelAttribute("users") UserRegistration userRegistration) {
        // save Student to database
        System.out.println("user searched "+ userRegistration.getHospitals().size());
        UserRegistration st1 = userRegistrationServices.findById(userRegistration.getId());
        Set<Hospital> selectedRequirement = userRegistration.getHospitals();
        Set<Hospital> existingRequirement = new HashSet<>();
        existingRequirement  = st1.getHospitals();
        Set<Hospital> allRequirement = new HashSet<>();
        allRequirement.addAll(existingRequirement);
        allRequirement.addAll(selectedRequirement);
        userRegistration.setHospitals(allRequirement);
        try {
            assignedRequirementsService.saveAssignedRequirement(userRegistration);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("An Error Occured while saving the Assigned Courses"+ex);
        }
        return "redirect:/students";

    }

    @GetMapping("/check-user-requirement/{id}")
    public String checkSelectedRequirement(@PathVariable(value = "id") Long id, Model model) {
        //get user from service
        UserRegistration userRegistration = userRegistrationServices.findById(id);
        // set requirement as model attribute to pre-populate the form
        model.addAttribute("user", userRegistration);
        // get list of selected Requirement;
        Set<Hospital>hospitals = userRegistration.getHospitals();
        model.addAttribute("hospital",hospitals);
        return "selectedRequirement";

    }

}
