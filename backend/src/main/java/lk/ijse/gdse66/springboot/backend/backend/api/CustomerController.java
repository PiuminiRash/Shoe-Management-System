package lk.ijse.gdse66.springboot.backend.backend.api;

import jakarta.validation.Valid;
import lk.ijse.gdse66.springboot.backend.backend.dto.CustomerDTO;
import lk.ijse.gdse66.springboot.backend.backend.dto.UserDTO;
import lk.ijse.gdse66.springboot.backend.backend.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
        System.out.println("customer working !");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public CustomerDTO save(@RequestBody CustomerDTO customerDTO){
//        System.out.println(customerDTO);
//
//        return customerService.saveCustomer(customerDTO);
//    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO save(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteEmployee(@PathVariable("id") String Code){
        customerService.deleteCustomer(Code);
    }


    @GetMapping("/nextId")
    public String nextId(){
      return customerService.generateNextId();
    }

    @GetMapping("/search")
    public List<CustomerDTO> search(@RequestParam("name") String name){
       return customerService.searchCustomer(name);
    }

}


//
// "code":"C001",
//         "name":"Navishka",
//         "email":"navishka@gmail.com",
//         "gender":"male",
//         "contact":"75518991",
//         "dob":"",
//         "addressLine1":"matara",
//         "addressLine2":"devinuwara",
//         "addressLine1":"matara",
//         "addressLine2":"devinuwara",
//         "addressLine1":"matara",
//         "loyaltyDate":"",
//         "loyaltyLevel":"",
//         "loyaltyPoints":2