package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lk.ijse.gdse66.springboot.backend.backend.util.SuplierCategory;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Sup_Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO implements Serializable {

    @NotBlank(message = "Supplier number is required")
    @Pattern(regexp = "^SU\\d{3}$", message = "Invalid Supplier number format. Must start with 'SU' followed by 3 digits.")
    private String code;
    private String name;
    private SuplierCategory category;
    private Sup_Address address;
    private String contact_1;
    private String contact_2;
    private String email;



}
