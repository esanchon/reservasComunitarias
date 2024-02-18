package com.amenity_reservation_system.repos;

import com.amenity_reservation_system.model.ComunidadServicio;
import com.amenity_reservation_system.model.Capacidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacityRepository extends JpaRepository<Capacidad, Long> {

    Capacidad findByAmenityType(ComunidadServicio amenityType);
}
