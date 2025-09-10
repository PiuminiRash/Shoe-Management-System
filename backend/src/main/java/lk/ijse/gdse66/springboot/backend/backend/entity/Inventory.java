package lk.ijse.gdse66.springboot.backend.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory  {

    @Id
    @Column(name = "item_code", nullable = false)
    private String itemCode;

    @Column(name = "item_description", nullable = false)
    private String itemDescription;

    @Column(name = "item_picture", columnDefinition = "LONGTEXT")
    private String itemPicture;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "qty", nullable = false)
    private Integer qty;
      @ManyToOne
      @JoinColumn(name = "supplier_code")
      private Supplier suplierEntity;

    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "unit_price_sale", nullable = false)
    private Double unitPriceSale;

    @Column(name = "unit_price_buy", nullable = false)
    private Double unitPriceBuy;

    @Column(name = "expected_profit", nullable = false)
    private Double expectedProfit;

    @Column(name = "profit_margin", nullable = false)
    private Double profitMargin;

    @Column(name = "status", nullable = false)
    private String status;



}
//{
//        "itemCode":"I001",
//        "itemDescription":"shoos",
//        "category":"Local",
//        "size":5,
//          "qty":2,
//        "suplierEntity":"S001",
//        "supplierName":"Navishka",
//        "unitPriceSale":"1000.00",
//        "unitPriceBuy":"500.00",
//        "expectedProfit":"200.00",
//        "profitMargin":"100.00",
//        "status":"hjhh"
//        }