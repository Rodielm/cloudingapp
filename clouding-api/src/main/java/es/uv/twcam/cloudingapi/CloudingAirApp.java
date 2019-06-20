package es.uv.twcam.cloudingapi;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uv.twcam.cloudingapi.entities.Airplane;
import es.uv.twcam.cloudingapi.entities.Airport;
import es.uv.twcam.cloudingapi.entities.Flight;
import es.uv.twcam.cloudingapi.entities.Passenger;
import es.uv.twcam.cloudingapi.entities.Reservation;
import es.uv.twcam.cloudingapi.entities.User;
import es.uv.twcam.cloudingapi.services.EntityService;

@SpringBootApplication
public class CloudingAirApp implements CommandLineRunner {
	

	@Autowired
	private EntityService<Airplane> airpleneService;

	@Autowired
	private EntityService<Flight> flightService;

	@Autowired
	private EntityService<Passenger> passengerService;

	@Autowired
	private EntityService<User> userService;

	@Autowired
	private EntityService<Reservation> reservationService;

	Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(CloudingAirApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		generateAircraft(10);

	}

	public void generateAircraft(int quantity) {

		for (int i = 0; i < quantity; i++) {
			Airplane airplane = new Airplane();
			airplane.setNumber(faker.bothify("##??"));
			airplane.setCapacity(Integer.parseInt(faker.options().option("60", "80", "100")));
			airpleneService.save(airplane);
		}

	}

	public void generateFlight(int quantity) {

		// List<AirportsDTO> airports = airportsService.findAll();
		for (int i = 0; i < quantity; i++) {

			Flight flight = new Flight();

			Airplane airplane = new Airplane();
			airplane.setId(faker.number().numberBetween(1, 20));

			Airport arrival = new Airport();
			arrival.setId(faker.number().numberBetween(1, 20));

			Airport takeoff = new Airport();
			takeoff.setId(faker.number().numberBetween(21, 40));

			flight.setAirplane(airplane);
			flight.setArrival(arrival);
			flight.setTakeoff(takeoff);
			flight.setPrice(300.00);
			flight.setStatus(true);

			int duration = faker.number().numberBetween(2, 12);
			Date takeoffDate = faker.date().future(duration, TimeUnit.DAYS);
			Calendar c = Calendar.getInstance();
			c.setTime(takeoffDate);
			c.add(Calendar.HOUR, faker.number().numberBetween(2, 12));
			Date arrivalDate = c.getTime();

			flight.setDuration(duration);
			flight.setTakeoffDate(takeoffDate);
			flight.setArrivalDate(arrivalDate);
			flightService.save(flight);
		}
	}

	public void generatePassenger(int quantity) {
		Faker faker = new Faker();

		for (int i = 0; i < quantity; i++) {
			Passenger p = new Passenger();
			p.setId(faker.number().numberBetween(1, 20));
			p.setName(faker.name().firstName());
			p.setLastname(faker.name().lastName());
			passengerService.save(p);
		}
	}

	public void generateUser(int quantity) {
		Faker faker = new Faker();

		for (int i = 0; i < quantity; i++) {
			User u = new User();
			u.setUsername(faker.name().firstName());
			u.setPassword("1234");
			u.setRol(faker.options().option("Agencia", "Aeropuerto", "Aerolinea"));
			userService.save(u);
		}

	}

	public void generateReservation(int records) {

		Reservation r = new Reservation();

		Flight flight = new Flight();
		flight.setId(11);

		r.setFlight(flight);
		r.setReservationDate(Calendar.getInstance().getTime());

		List<Passenger> passengers = passengerService.getAll();

		for (int i = 0; i < 3; i++) {
			r.setPaid(true);

			r.setPassenger(passengers.get(faker.number().numberBetween(0, passengers.size())));
			r.setLuggages(Faker.instance().number().numberBetween(1, 5));
			r.setPriority(true);
			r.setPrice(Double.valueOf(Faker.instance().commerce().price(30.00, 100.00)));
			reservationService.save(r);
		}

	}



}
