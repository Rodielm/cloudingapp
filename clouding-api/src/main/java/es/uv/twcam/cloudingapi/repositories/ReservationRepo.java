package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.twcam.cloudingapi.entities.Reservation;


/**
 * ReservationRepo
 */

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Integer>{

    
}