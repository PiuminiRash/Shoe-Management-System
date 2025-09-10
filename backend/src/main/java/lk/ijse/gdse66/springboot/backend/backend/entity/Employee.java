package lk.ijse.gdse66.springboot.backend.backend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.springboot.backend.backend.util.Gender;
import lk.ijse.gdse66.springboot.backend.backend.util.Role;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Em_Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_code", unique = true, nullable = false)
    private String employeeCode;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_profile_pic" , columnDefinition = "LONGTEXT")
    private String employeeProfilePic;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_role")
    private Role accessRole;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "date_of_join")
    private Date dateOfJoin;

    @Column(name = "attached_branch")
    private String attachedBranch;


    private Em_Address address;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "emergency_contact_person")
    private String emergencyContactPerson;
}
