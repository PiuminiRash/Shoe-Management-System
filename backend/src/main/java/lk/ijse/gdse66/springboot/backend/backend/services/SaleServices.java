package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SaleServices {

    List<SaleDTO> getAllSales();
    SaleDTO getSaleDetails(String id);
    SaleDTO saveSales(SaleDTO salesDTO);
    void updateSales(String id, SaleDTO salesDTO);
    void deleteSales(String id);

}
