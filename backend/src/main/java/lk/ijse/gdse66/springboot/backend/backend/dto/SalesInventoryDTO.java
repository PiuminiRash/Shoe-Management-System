package lk.ijse.gdse66.springboot.backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesInventoryDTO {

    @Null
    private String id;

   private InventoryDTO inventory;


    private String itemDescription;


    private Integer size;

    @NotNull(message = "Unit price is required")
    private Double unitPriceSale;

    @NotNull(message = "Item quantity is required")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Invalid quantity format. Must be a positive integer.")
    private Integer quantity;

    private SaleDTO sales;
}
