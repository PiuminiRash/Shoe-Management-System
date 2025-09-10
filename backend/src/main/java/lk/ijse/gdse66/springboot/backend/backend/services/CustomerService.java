package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomer(String name);

    String generateNextId();
}
