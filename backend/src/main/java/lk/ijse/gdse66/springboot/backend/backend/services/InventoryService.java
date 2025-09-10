package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.InventoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InventoryService {

    List<InventoryDTO> getAllInventory();
    InventoryDTO getInventoryDetails(String id);
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    InventoryDTO updateInventory(InventoryDTO inventoryDTO);
    void deleteInventory(String id);
}
