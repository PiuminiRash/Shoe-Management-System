package lk.ijse.gdse66.springboot.backend.backend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.springboot.backend.backend.util.CustomerLoyaltyLevel;
import lk.ijse.gdse66.springboot.backend.backend.util.Gender;
import lk.ijse.gdse66.springboot.backend.backend.util.embeddebleTable.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
//@GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String contact;
    private Date dob;
    private Address address;

    private Date loyaltyDate;
    @Enumerated(EnumType.STRING)
    private CustomerLoyaltyLevel loyaltyLevel;
    private Integer loyaltyPoints;
    private Timestamp recentPurchaseDate;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User userEntity;

    @OneToMany(mappedBy ="customerEntity")
    private List<Sales> saleEntities;

}
