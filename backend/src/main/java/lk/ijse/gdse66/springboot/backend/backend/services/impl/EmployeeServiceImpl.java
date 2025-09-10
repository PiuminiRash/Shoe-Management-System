package lk.ijse.gdse66.springboot.backend.backend.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.springboot.backend.backend.dto.EmployeeDTO;
import lk.ijse.gdse66.springboot.backend.backend.entity.Employee;
import lk.ijse.gdse66.springboot.backend.backend.repository.EmployeeRepo;
import lk.ijse.gdse66.springboot.backend.backend.services.EmployeeService;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.DuplicateRecordException;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
     private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAll().stream().map(
                employee -> modelMapper.map(employee, EmployeeDTO.class)
        ).toList();
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String id) {
        if(!employeeRepo.existsByEmployeeCode(id)){
            throw new NotFoundException("Employee "+id+" Not Found!");
        }
        return modelMapper.map(employeeRepo.findByEmployeeCode(id), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepo.existsByEmployeeCode(employeeDTO.getEmployeeCode())){
            throw new DuplicateRecordException("This Employee "+employeeDTO.getEmployeeCode()+" already exicts...");
        }
        return modelMapper.map(employeeRepo.save(modelMapper.map(
                employeeDTO, Employee.class)), EmployeeDTO.class
        );
    }

    @Override
    public EmployeeDTO updateEmployee( EmployeeDTO employeeDTO) {
        if (!employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new NotFoundException("Can't find customer id !!");
        }
        return modelMapper.map(employeeRepo.save(modelMapper.map(employeeDTO,Employee.class)), EmployeeDTO.class);
    }
//
//        Employee existingEmployee = employeeRepo.findByEmployeeCode(id);
//
//        if(existingEmployee.getEmployeeName().isEmpty()){
//            throw new NotFoundException("Employee ID"+ id + "Not Found...");
//        }
//
//        existingEmployee.setEmployeeName(employeeDTO.getEmployeeName());
//        existingEmployee.setGender(employeeDTO.getGender());
//
//        employeeRepo.save(existingEmployee);
//    }

    @Override
    public void deleteEmployee(String id) {

        if(!employeeRepo.existsByEmployeeCode(id)){
            throw  new NotFoundException("Employee ID"+ id + "Not Found...");
        }
        employeeRepo.deleteByEmployeeCode(id);
    }
    }

