package lk.ijse.gdse66.springboot.backend.backend.api;

import lk.ijse.gdse66.springboot.backend.backend.dto.InventoryDTO;
import lk.ijse.gdse66.springboot.backend.backend.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin
public class InventoryController {
@Autowired
    private  InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryDTO saveInventory(@RequestPart("data") InventoryDTO inventoryDTO, @RequestPart("itempic") MultipartFile itempic) throws IOException {
        String base64ProfilePic = Base64.getEncoder().encodeToString(itempic.getBytes());
        inventoryDTO.setItemPicture(base64ProfilePic);
        return inventoryService.saveInventory(inventoryDTO);

    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateInventory(@RequestPart("data") InventoryDTO inventoryDTO, @RequestPart("itempic") MultipartFile itempic) throws IOException {
        String base64ProfilePic = Base64.getEncoder().encodeToString(itempic.getBytes());
        inventoryDTO.setItemPicture(base64ProfilePic);
        inventoryService.updateInventory(inventoryDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteInventory(@PathVariable("id") String itemCode) {
        inventoryService.deleteInventory(itemCode);
    }

    @PatchMapping(value = "/{id}")
    public InventoryDTO getInventory(@PathVariable("id") String id) {
        return inventoryService.getInventoryDetails(id);
    }
}



//{
//        "itemCode": "I002",
//        "itemDescription": "Shoe-shampoo",
//        "qty": 20,
//        "category": "Local",
//        "size": 5,
//        "suplierEntity": "SU001",
//        "supplierName": "samanth nanayakkara",
//
//        "unitPriceSale": "1000.00",
//        "unitPriceBuy": "500.00",
//        "expectedProfit": "200.00",
//        "profitMargin": "100.00",
//        "status": "low"
//        }


