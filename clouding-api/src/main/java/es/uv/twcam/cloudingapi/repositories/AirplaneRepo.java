package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uv.twcam.cloudingapi.entities.Airplane;

/**
 * AirplaneRepo
 */


public interface AirplaneRepo extends JpaRepository<Airplane,Integer>{

    
}