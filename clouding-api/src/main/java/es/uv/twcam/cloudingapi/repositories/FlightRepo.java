package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uv.twcam.cloudingapi.entities.Flight;

/**
 * FlightRepo
 */

public interface FlightRepo extends JpaRepository<Flight, Integer> {

    
}