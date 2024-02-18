package com.amenity_reservation_system.repos;

import com.amenity_reservation_system.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findUserByUsername(String username);
}
