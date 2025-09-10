package lk.ijse.gdse66.springboot.backend.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sales {

    @Id
    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "added_points")
    private Double addedPoints;

    @Column(name = "cashier_name")
    private String cashierName;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User userEntity;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customerEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "sales")
    private List<SalesDetails> salesDetails = new ArrayList<>();


}
