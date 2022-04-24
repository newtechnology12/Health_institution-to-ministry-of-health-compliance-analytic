package com.HealthInstitution.ComplianceAnalytic.backend_model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="user")
@DynamicUpdate(true)
public class UserRegistration {
    @Id
    private Long id;
    private String FirstName;
    private String LastName;
    private  String Location;
    private HealphcareCategory healphcareCategory;
    private Date StatingDate;
    private Date TodayDate;
    private String UserName;
    private String Email;
    private  String Password;
    private boolean Active;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinTable(name = "User_Hospital", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "hospital_id") })
    private Set<Hospital> hospitals = new HashSet<>();

    public UserRegistration() {
    }

    public UserRegistration(Long id, String firstName, String lastName, String location, HealphcareCategory healphcareCategory, Date statingDate, Date todayDate, String userName, String email, String password, boolean active) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Location = location;
        this.healphcareCategory = healphcareCategory;
        StatingDate = statingDate;
        TodayDate = todayDate;
        UserName = userName;
        Email = email;
        Password = password;
        Active = active;
    }

    public UserRegistration(String firstName, String lastName, String location, HealphcareCategory healphcareCategory, Date statingDate, Date todayDate, String userName, String email, String password, boolean active) {
        FirstName = firstName;
        LastName = lastName;
        Location = location;
        this.healphcareCategory = healphcareCategory;
        StatingDate = statingDate;
        TodayDate = todayDate;
        UserName = userName;
        Email = email;
        Password = password;
        Active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public HealphcareCategory getHealphcareCategory() {
        return healphcareCategory;
    }

    public void setHealphcareCategory(HealphcareCategory healphcareCategory) {
        this.healphcareCategory = healphcareCategory;
    }

    public Date getStatingDate() {
        return StatingDate;
    }

    public void setStatingDate(Date statingDate) {
        StatingDate = statingDate;
    }

    public Date getTodayDate() {
        return TodayDate;
    }

    public void setTodayDate(Date todayDate) {
        TodayDate = todayDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public Set<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Location='" + Location + '\'' +
                ", healphcareCategory=" + healphcareCategory +
                ", StatingDate=" + StatingDate +
                ", TodayDate=" + TodayDate +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Active=" + Active +
                ", hospitals=" + hospitals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistration that = (UserRegistration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
