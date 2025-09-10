package lk.ijse.gdse66.springboot.backend.backend.services.impl;

import lk.ijse.gdse66.springboot.backend.backend.dto.UserDTO;
import lk.ijse.gdse66.springboot.backend.backend.entity.User;
import lk.ijse.gdse66.springboot.backend.backend.repository.UserRepo;
import lk.ijse.gdse66.springboot.backend.backend.services.UserService;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.DuplicateRecordException;
import lk.ijse.gdse66.springboot.backend.backend.services.exception.NotFoundException;
import org.modelmapper.ModelMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepo userRepository;
@Autowired

    private ModelMapper modelMapper;



//    @Override
//    public UserDetailsService userDetailService() {
//        return username -> userRepository.findByEmail(username)
//                .orElseThrow(() -> new
//                        UsernameNotFoundException(
//                        "user not found"));
//    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(
                user -> modelMapper.map(user, UserDTO.class)
        ).toList();
    }

    @Override
    public UserDTO getUserDetails(String email, String role) {
        if(!userRepository.existsByEmail(email)){
            throw new NotFoundException("User email :"+email+" Not Found!");
        }
        return modelMapper.map(userRepository.findByEmailAndRole(email,role), UserDTO.class);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new DuplicateRecordException("This User "+userDTO.getEmail()+" already have an account.");
        }
        return modelMapper.map(userRepository.save(modelMapper.map(
                userDTO, User.class)), UserDTO.class
        );
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if (!userRepository.existsById(userDTO.getEmail())){
            throw new NotFoundException("Can't find user id !!");
        }
        return modelMapper.map(userRepository.save(modelMapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public void deleteUser(String email) {

        if(!userRepository.existsByEmail(email)){
            throw  new NotFoundException("User email :"+ email + "Not Found...");
        }
        userRepository.deleteByEmail(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}
