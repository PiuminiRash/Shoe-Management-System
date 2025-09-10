package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private List<SalesInventoryDTO> inventory;

    @NotBlank(message = "Order number is required")
    @Pattern(regexp = "^ORD\\d{3}$", message = "Invalid order number format. Must start with 'ORD' followed by 3 digits.")
    private String orderNo;


    private String customerName;

    @NotNull(message = "Total price is required")
    private Double totalPrice;

    @NotNull(message = "Purchase date is required")
    private LocalDateTime purchaseDate;

    @NotBlank(message = "Payment method is required")
    @Pattern(regexp = "^(cash|card)$", message = "Invalid payment method. Must be 'cash' or 'card'.")
    private String paymentMethod;

    private Double addedPoints;


    @NotBlank(message = "Cashier name is required")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid name format")
    private String cashierName;

    private Date date;

    private UserDTO userEntity;

    private CustomerDTO customerEntity;
 /*
    Example JSON:
    {
        "orderNo": "ORD0001",
        "customerName": "Navishka",
        "totalPrice": 2000.00,
        "purchaseDate": "2023-12-31T12:00:00",
        "paymentMethod": "cash",
        "addedPoints": 10.00,
        "cashierName": "Amal Smith"
    }
    */
}
//{
//        "orderNo": "ORD0001",
//        "customerName": "Navishka",
//        "totalPrice": 2000.00,
//        "purchaseDate": "2023-12-31T12:00:00",
//        "paymentMethod": "cash",
//        "addedPoints": 10.00,
//        "cashierName": "Amal Smith",
//        "inventory": [
//        {
//        "itemCode": "ITEM001",
//        "quantity": 2,
//        "price": 500.00
//        },
//        {
//        "itemCode": "ITEM002",
//        "quantity": 1,
//        "price": 1000.00
//        }
//        ],
//        "userEntity": {
//        "userId": "USR001",
//        "username": "john_doe",
//        "email": "john@example.com"
//        },
//        "customerEntity": {
//        "customerId": "CUST001",
//        "name": "Navishka",
//        "contactNumber": "0771234567",
//        "email": "navishka@example.com"
//        }
//        }
