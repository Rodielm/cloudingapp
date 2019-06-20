package es.uv.twcam.cloudingapi.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.uv.twcam.cloudingapi.entities.Reservation;
import es.uv.twcam.cloudingapi.services.MonthlyProfitsDTO;
import es.uv.twcam.cloudingapi.services.PassengersPriorityDTO;
import es.uv.twcam.cloudingapi.services.ProfitFlightsDTO;

/**
 * ReservationRepo
 */

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Integer>{

   public Optional<Reservation> findById(Integer reservation);

	// Q3-1
	@Query("Select r from Reservation r  inner join r.flight f where f.arrivalDate > :today and r.user.id = :userId ")
	public List<Reservation> findByFlightPendient(@Param("today") Date today,
			@Param("user") Long userId);

	// Q3-2
	@Query("Select r from Reservation r  inner join r.flight f where f.arrivalDate < :today and r.user.id = :userId ")
	public List<Reservation> findByFlightDone(@Param("today") Date today,
			@Param("userId") Integer userId);

	// Q6
	@Query("SELECT new es.uv.twcam.cloudingapi.service.PassengersPriorityDTO(p.id, p.name, p.lastname,  COUNT(p)) "
			+ "FROM Reservation r " + "INNER JOIN r.passenger p " + "where r.priority = 1 "
			+ "GROUP BY p.id " + "HAVING COUNT(p) > ?1")
	public List<PassengersPriorityDTO> getPassengerPriority(Integer priority);

	// Q7
	@Query("SELECT es.uv.twcam.cloudingapi.ProfitFlightsDTO(A.municipality, A.continent, A.id, SUM(RP.flightRate)) "
			+ "FROM Reservation r INNER JOIN R.flight f "
			+ "INNER JOIN f.airportArrival A " + "WHERE r.reservationDate BETWEEN :start AND :end "
			+ "GROUP BY f.airportArrival " + "ORDER BY SUM(r.flightRate) DESC")
	public List<ProfitFlightsDTO> findTop10ProfitsFlights(Pageable pageable, @Param("start") Date startDate,
			@Param("end") Date endDate);
    
	// Q8
	@Query("SELECT new es.uv.twcam.cloudingapi.service.MonthlyProfitsDTO(YEAR(R.reservationDate), MONTH(R.reservationDate), sum(R.price)) "
			+ "FROM Reservation R GROUP BY YEAR(R.reservationDate), MONTH(R.reservationDate) "
			+ "ORDER BY YEAR(R.reservationDate), MONTH(R.reservationDate) DESC")
	public List<MonthlyProfitsDTO> getMonthlyProfits(Pageable pageable);

    
}