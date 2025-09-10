package lk.ijse.gdse66.springboot.backend.backend.repository;


import lk.ijse.gdse66.springboot.backend.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);
}
