package lk.ijse.gdse66.springboot.backend.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.gdse66.springboot.backend.backend.util.SuplierCategory;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Sup_Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private SuplierCategory category;
    private Sup_Address address;
    private String contact_1;
    private String contact_2;
    private String email;
}
//{
//        "code": "SU001",
//        "name": "samanth nanayakkara",
//        "category": "Local", // Change "BRONZE" to "Local" or "International"
//        "addressLine1": "hello",
//        "addressLine2": "rode",
//        "addressLine3": "23A",
//        "addressLine4": "Galle",
//        "addressLine5": "324",
//        "contact_1": "0775644232",
//        "contact_2": "0725644112",
//        "email": "samn2@gmail.com"
//        }