package com.amenity_reservation_system.repos;

import com.amenity_reservation_system.model.ComunidadServicio;
import com.amenity_reservation_system.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findReservationsByAmenityType(ComunidadServicio amenityType);

    List<Reserva> findReservationsByReservationDateAndStartTimeBeforeAndEndTimeAfterOrStartTimeBetween
            (LocalDate reservationDate, LocalTime startTime, LocalTime endTime, LocalTime betweenStart, LocalTime betweenEnd);
}
