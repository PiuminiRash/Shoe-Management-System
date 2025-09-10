package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {

    @NotBlank(message = " Inventory number is required")
    @Pattern(regexp = "^I\\d{3}$", message = "Invalid Inventory number format. Must start with 'I' followed by 3 digits.")

    private String itemCode;

    @NotBlank(message = "Item description is required")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid item description format. Only alphanumeric characters and spaces are allowed.")
    private String itemDescription;

    private String itemPicture;

        private Integer qty;

    @NotBlank(message = "Category is required")
    @Pattern(regexp = "^(International|Local)$", message = "Invalid category. Must be 'International' or 'Local'.")
    private String category;

    @NotNull(message = "Size is required")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Invalid size format. Must be a positive integer.")
    private Integer size;

    @JoinColumn(name = "Sup_Code")
    private SupplierDTO suplierEntity;

    @NotBlank(message = "Supplier name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Invalid supplier name format. Only alphabetic characters and spaces are allowed.")
    private String supplierName;

    @NotNull(message = "Unit price (sale) is required")
    private Double unitPriceSale;

    @NotNull(message = "Unit price (buy) is required")
    private Double unitPriceBuy;


    @NotNull(message = "Expected profit is required")
    private Double expectedProfit;


    @NotNull(message = "Profit margin is required")
    @Pattern(regexp = "^(0*(?:[1-9]\\d{0,2}(?:,\\d{3})*|0)(?:\\.\\d+)?|)$", message = "Invalid profit margin format. Must be a non-negative decimal number.")
    private Double profitMargin;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^(low|available|not available)$", message = "Invalid status. Must be 'low', 'available', or 'not available'.")
    private String status;
}
//{
//        "itemCode":"I001",
//        "itemDescription":"Polish",
//        "category":"Local",
//        "size":5,
//          "qty":2,
//        "suplierEntity":"SU001",
//        "supplierName":"samanth nanayakkara",
//        "unitPriceSale":"1000.00",
//        "unitPriceBuy":"500.00",
//        "expectedProfit":"200.00",
//        "profitMargin":"100.00",
//        "status":"low"
//        }




//{
//        "itemCode": "I001",
//        "itemDescription": "Shoes",
//        "qty": 2,
//        "category": "Local",
//        "size": 5,
//        "suplierEntity": "S001",
//        "supplierName": "samanth nanayakkara",
//
//        "unitPriceSale": 1000.00,
//        "unitPriceBuy": 500.00,
//        "expectedProfit": 200.00,
//        "profitMargin": 100.00,
//        "status": "low"
//        }

