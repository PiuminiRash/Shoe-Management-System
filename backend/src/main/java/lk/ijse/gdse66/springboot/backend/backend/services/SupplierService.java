package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SupplierService {

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    SupplierDTO updateSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String id);
    List<SupplierDTO> getAllSuppliers();
    List<SupplierDTO> searchSupplier(String name);
    String generateNextId();
}
