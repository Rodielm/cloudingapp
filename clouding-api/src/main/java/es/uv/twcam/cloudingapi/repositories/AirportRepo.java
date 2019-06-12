package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.twcam.cloudingapi.entities.Airport;

/**
 * Airport
 */

public interface AirportRepo  extends JpaRepository<Airport,Integer > {

    
}