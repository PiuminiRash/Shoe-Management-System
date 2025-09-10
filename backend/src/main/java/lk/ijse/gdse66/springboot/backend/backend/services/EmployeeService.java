package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeDetails(String id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee( EmployeeDTO employeeDTO);

    void deleteEmployee(String id);
}
