package lk.ijse.gdse66.springboot.backend.backend.api;

import jakarta.validation.Valid;
import lk.ijse.gdse66.springboot.backend.backend.dto.UserDTO;
import lk.ijse.gdse66.springboot.backend.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO saveUser(@Valid @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteUser(@PathVariable("id") String email){
        userService.deleteUser(email);
    }


    @PatchMapping(value = "/{email}/{role}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    UserDTO getUser(@PathVariable("email") String email, @PathVariable("role") String role){
        return userService.getUserDetails(email ,role);
    }




}
