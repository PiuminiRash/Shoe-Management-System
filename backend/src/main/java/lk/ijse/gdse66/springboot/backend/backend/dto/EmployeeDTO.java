package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lk.ijse.gdse66.springboot.backend.backend.util.Gender;
import lk.ijse.gdse66.springboot.backend.backend.util.Role;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Em_Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Employee number is required")
    @Pattern(regexp = "^EMP\\d{3}$", message = "Invalid employee number format. Must start with 'EMP' followed by 3 digits.")

    private String employeeCode;

    @NotBlank(message = "Employee Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid name format")
    private String employeeName;

    private String employeeProfilePic;

    private Gender gender;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotBlank(message = "Designation cannot be blank")
    private String designation;

    private Role accessRole;

    @NotNull(message = "Date of Birth cannot be null")
    private Date dob;

    @NotNull(message = "Date of Joining cannot be null")
    private Date dateOfJoin;

    private String attachedBranch;

//    @NotBlank(message = "Address Line 01 cannot be blank")
    private Em_Address address;


    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid contact number format. Must be a 10-digit number.")
    private String contactNo;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    private String emergencyContactPerson;

}
