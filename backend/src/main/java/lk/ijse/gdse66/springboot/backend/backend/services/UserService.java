package lk.ijse.gdse66.springboot.backend.backend.services;

import lk.ijse.gdse66.springboot.backend.backend.dto.UserDTO;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService
{

  //  UserDetailsService userDetailService();
    List<UserDTO> getAllUser();
    UserDTO getUserDetails(String email,String role);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(String email);
}
