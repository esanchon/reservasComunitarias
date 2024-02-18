package com.amenity_reservation_system;

import com.amenity_reservation_system.model.ComunidadServicio;
import com.amenity_reservation_system.model.Capacidad;
import com.amenity_reservation_system.model.Usuario;
import com.amenity_reservation_system.repos.CapacityRepository;
import com.amenity_reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ServicioDeReservasComunitarioApplication {

  private Map<ComunidadServicio, Integer> initialCapacities =
      new HashMap<>() {
        {
          put(ComunidadServicio.Gimnasio, 20);
          put(ComunidadServicio.Piscina, 4);
          put(ComunidadServicio.Padel, 1);
        }
      };

  public static void main(String[] args) {
    SpringApplication.run(ServicioDeReservasComunitarioApplication.class, args);
  }

  @Bean
  public CommandLineRunner loadData(UserRepository userRepository,CapacityRepository capacityRepository) {
    return (args) -> {
      userRepository.save(
          new Usuario("Yigit Kemal Erinc", "yigiterinc", bCryptPasswordEncoder().encode("12345")));

      for (ComunidadServicio amenityType : initialCapacities.keySet()) {
        capacityRepository.save(new Capacidad(amenityType, initialCapacities.get(amenityType)));
      }
    };
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
