package lk.ijse.gdse66.springboot.backend.backend.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.springboot.backend.backend.dto.InventoryDTO;
import lk.ijse.gdse66.springboot.backend.backend.entity.Inventory;
import lk.ijse.gdse66.springboot.backend.backend.repository.InventoryRepo;
import lk.ijse.gdse66.springboot.backend.backend.services.InventoryService;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.DuplicateRecordException;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
@Autowired
   private InventoryRepo inventoryRepo;
@Autowired
   private ModelMapper modelMapper;



    @Override
    public List<InventoryDTO> getAllInventory() {
        return inventoryRepo.findAll().stream().map(
                inventory -> modelMapper.map(inventory, InventoryDTO.class)
        ).toList();
    }

    @Override
    public InventoryDTO getInventoryDetails(String id) {
        if(!inventoryRepo.existsByItemCode(id)){
            throw new NotFoundException("Inventory "+id+" Not Found!");
        }
        return modelMapper.map(inventoryRepo.findByItemCode(id), InventoryDTO.class);
    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        if(inventoryRepo.existsByItemCode(inventoryDTO.getItemCode())){
            throw new DuplicateRecordException("This Inventory "+inventoryDTO.getItemCode()+" already exicts...");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(
                inventoryDTO, Inventory.class)), InventoryDTO.class
        );
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {

        if (!inventoryRepo.existsById(inventoryDTO.getItemCode())){
            throw new NotFoundException("Can't find customer id !!");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class)), InventoryDTO.class);
    }

    @Override
    public void deleteInventory(String id) {

        if(!inventoryRepo.existsByItemCode(id)){
            throw  new NotFoundException("Inventory "+ id + "Not Found...");
        }
        inventoryRepo.deleteByItemCode(id);
    }
}
