package es.uv.twcam.cloudingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudingAirApp {
	// usuario(agencia,aerolinea y aeropuerto)
	// pasajeros > reservas
	// agencias > reservas
	// Usuario(aerolinea) > vuelos 
	// Usuario(Aeropuerto) este solo puede consultar información

	
	// 
	public static void main(String[] args) {
		SpringApplication.run(CloudingAirApp.class, args);
	}

}
