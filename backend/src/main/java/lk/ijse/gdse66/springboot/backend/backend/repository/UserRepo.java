package lk.ijse.gdse66.springboot.backend.backend.repository;

import lk.ijse.gdse66.springboot.backend.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,String> {

    Boolean existsByEmail(String email);
    User findByEmailAndRole(String email,String role);
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);

}
