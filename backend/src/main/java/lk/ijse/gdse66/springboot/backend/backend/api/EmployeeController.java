package lk.ijse.gdse66.springboot.backend.backend.api;

import lk.ijse.gdse66.springboot.backend.backend.dto.EmployeeDTO;
import lk.ijse.gdse66.springboot.backend.backend.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO saveEmployee(@RequestPart("data") EmployeeDTO employeeDTO, @RequestPart("profilepic") MultipartFile profilepic) throws IOException {
        String base64ProfilePic = Base64.getEncoder().encodeToString(profilepic.getBytes());
        employeeDTO.setEmployeeProfilePic(base64ProfilePic);
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestPart("data") EmployeeDTO employeeDTO, @RequestPart("profilepic") MultipartFile profilepic) throws IOException {
        String base64ProfilePic = Base64.getEncoder().encodeToString(profilepic.getBytes());
        employeeDTO.setEmployeeProfilePic(base64ProfilePic);
        employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") String employeeCode) {
        employeeService.deleteEmployee(employeeCode);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployee(@PathVariable("id") String id) {
        return employeeService.getEmployeeDetails(id);
    }
}


//
//{
//        "employeeCode": "EMP002",
//        "employeeName": "amal perera",
//        "gender": "MALE",
//        "status": "Active",
//        "designation": "Software ",
//        "accessRole": "ADMIN",
//        "dob": "2000-01-01",
//        "dateOfJoin": "2020-10-01",
//        "attachedBranch": "galle ",
//        "addressLine01": "12 Main Street",
//        "addressLine02": "Galle",
//        "addressLine03": "Western Province",
//        "addressLine04": "Sri Lanka",
//        "addressLine05": "12345",
//        "contactNo": "+94123488689",
//        "email": "amal.doe@example.com",
//        "emergencyContactPerson": "Jane Doe"
//        }
