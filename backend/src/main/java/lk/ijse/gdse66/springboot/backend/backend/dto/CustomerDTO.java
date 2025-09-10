package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lk.ijse.gdse66.springboot.backend.backend.entity.User;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Address;
import lk.ijse.gdse66.springboot.backend.backend.util.CustomerLoyaltyLevel;
import lk.ijse.gdse66.springboot.backend.backend.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {

    @NotBlank(message = "Customer number is required")
    @Pattern(regexp = "^C\\d{3}$", message = "Invalid customer number format. Must start with 'C' followed by 3 digits.")
    private String code;

    @NotBlank(message = "Customer name is required")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid name format")
    private String name;

    @JoinColumn(name = "user_email")
    private UserDTO userEntity;

    @NotBlank(message = "Email Cannot Be Null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email not valid")
    private String email;
    private Gender gender;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid contact number format. Must be a 10-digit number.")
    private String contact;

    private Date dob;
    private Address address;
    private Date loyaltyDate;
    private CustomerLoyaltyLevel loyaltyLevel;
    private Integer loyaltyPoints;
//    private Timestamp recentPurchaseDate;


}
