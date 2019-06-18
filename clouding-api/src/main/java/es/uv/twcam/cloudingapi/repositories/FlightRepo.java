package es.uv.twcam.cloudingapi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uv.twcam.cloudingapi.entities.Flight;

/**
 * FlightRepo
 */

public interface FlightRepo extends JpaRepository<Flight, Integer> {


	/* Q1 */
	@Query("SELECT f FROM Flight f "
            + "WHERE f.takeoff.id = :takeoffId AND f.arrival.id = :arrivalId"
            + "AND f.takeoffDate > :fechaMin AND f.takeoffDate < :fechaMax "
			+ " AND f.airplane.capacity > (select count(*) from f.Reservations r where r.flight.id = f.flight.id)")
	List<Flight> retrieveByFiltersAndFreePax(@Param("takeoffId") String idOrigen,
			@Param("idDestino") String idDestino,
			@Param("reservar") Integer plazas,
			@Param("fechaMin") Date fechaMin,
			@Param("fechaMax") Date fechaMax);
	
	@Query(value="SELECT * FROM Flight f "
			+ "WHERE f.takeoffDate BETWEEN DATE_SUB(:date, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY) "
			+ "ORDER BY f.price DESC", nativeQuery = true)
	List<Flight> retrieveByDateDiff(@Param("date") Date date);
    
}