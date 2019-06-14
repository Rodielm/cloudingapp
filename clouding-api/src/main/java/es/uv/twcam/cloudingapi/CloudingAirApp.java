package es.uv.twcam.cloudingapi;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uv.twcam.cloudingapi.entities.Airplane;
import es.uv.twcam.cloudingapi.services.EntityService;

@SpringBootApplication
public class CloudingAirApp implements CommandLineRunner {
	// usuario(agencia,aerolinea y aeropuerto)
	// pasajeros > reservas
	// agencias > reservas
	// Usuario(aerolinea) > vuelos 
	// Usuario(Aeropuerto) este solo puede consultar información

	@Autowired
	private EntityService<Airplane> airplenRepo;

	public static void main(String[] args) {
		SpringApplication.run(CloudingAirApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		generateAircraft(10);

	}


	public void generateAircraft(int quantity) {

		Faker faker = new Faker();

		for (int i = 0; i < quantity; i++) {
			Airplane airplane = new Airplane();
			airplane.setNumber(faker.bothify("##??"));
			airplane.setCapacity(Integer.parseInt(faker.options().option("60", "80", "100")));
			airplenRepo.save(airplane);
		}

	}

}
