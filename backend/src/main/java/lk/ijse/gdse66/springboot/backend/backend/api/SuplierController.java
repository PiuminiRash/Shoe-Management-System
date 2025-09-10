package lk.ijse.gdse66.springboot.backend.backend.api;


import lk.ijse.gdse66.springboot.backend.backend.dto.SupplierDTO;
import lk.ijse.gdse66.springboot.backend.backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
@CrossOrigin(origins = "*")
public class SuplierController {

    @Autowired
    private SupplierService supplierService;

    public SuplierController() {
        System.out.println("customer working !");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SupplierDTO> getAllCustomers(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SupplierDTO update(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.updateSupplier(supplierDTO);
    }

    @GetMapping("/nextId")
    public String nextId(){
        return supplierService.generateNextId();
    }

    @GetMapping("/search")
    public List<SupplierDTO> search(@RequestParam("name") String name){
        return supplierService.searchSupplier(name);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable("id") String Code){
        supplierService.deleteSupplier(Code);
    }


}



//{
//        "code": "S001",
//        "name": "Navishka",
//        "category": "BRONZE",
//        "addressLine1": "matara",
//        "addressLine2": "devinuwara",
//        "addressLine3": "devinuwara",
//        "addressLine4": "devinuwara",
//        "addressLine5": "devinuwara",
//        "contact_1": "755738991",
//        "contact_2": "755734991",
//        "email": "navishka@gmail.com"
//        }