package lk.ijse.gdse66.springboot.backend.backend.repository;

import lk.ijse.gdse66.springboot.backend.backend.entity.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailsRepo extends JpaRepository<SalesDetails,String> {

    Boolean existsBySalesOrderNo(String id);
    List<SalesDetails> findAllBySalesOrderNo(String id);
    void deleteAllBySalesOrderNo(String id);
    Boolean existsAllBySalesOrderNo(String id);
}
