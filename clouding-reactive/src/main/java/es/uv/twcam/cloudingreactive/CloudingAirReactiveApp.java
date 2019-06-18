package es.uv.twcam.cloudingreactive;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uv.twcam.cloudingreactive.collection.AirportControl;
import es.uv.twcam.cloudingreactive.collection.StoreControl;
import es.uv.twcam.cloudingreactive.services.CollectionService;

@SpringBootApplication
public class CloudingAirReactiveApp implements CommandLineRunner {


	Faker faker = new Faker();
	
	@Autowired
	private CollectionService<StoreControl> storeService;

	@Autowired
	private CollectionService<AirportControl> airportService;

	public static void main(String[] args) {
		SpringApplication.run(CloudingAirReactiveApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		airportService.deleteAll();
		storeService.deleteAll();
		generateAirportControl(10);
		generatePurchaseControl(10);

	}


	public void generateAirportControl(int records) {

		List<String> airport = new ArrayList<>();
		List<String> passengers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			airport.add(faker.bothify("??###"));
		}

		for (int i = 0; i < 10; i++) {
			passengers.add(faker.bothify("########?"));
		}

		Calendar c = Calendar.getInstance();

		for (int i = 0; i < records; i++) {

			c.setTime(faker.date().past(faker.number().numberBetween(30, 60), TimeUnit.MINUTES));

			if (1 == faker.number().numberBetween(0, 1))
				c.add(Calendar.YEAR, -1);

			c.add(Calendar.MINUTE, -faker.number().numberBetween(30, 60));
			Date past = c.getTime();

			c.add(Calendar.MINUTE, faker.number().numberBetween(30, 60));
			Date future = c.getTime();

			AirportControl airportControl = new AirportControl();
			airportControl.setAirportStart(airport.get(faker.number().numberBetween(0, 4)));
			airportControl.setAirportEnd(airport.get(faker.number().numberBetween(5, 9)));
			airportControl.setGate(faker.bothify("?#"));
			airportControl.setSecurityCheck(past);
			airportControl.setBoarding(future);
			airportControl.setReservationId(Integer.valueOf(faker.bothify("######")));
			airportService.add(airportControl);
		}

	}

	public void generatePurchaseControl(int records) {

		List<String> airport = new ArrayList<>();
		List<String> passengers = new ArrayList<>();
		List<Double> spend = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			airport.add(faker.bothify("??###"));
		}

		for (int i = 0; i < 10; i++) {
			passengers.add(faker.bothify("########?"));
		}

		for (int i = 0; i < records; i++) {

			Calendar before = Calendar.getInstance();
			before.add(Calendar.YEAR, -1);

			int qtyPurchase = faker.number().numberBetween(1, 6);

			for (int j = 0; j < qtyPurchase; j++) {
				spend.add(Double.parseDouble(faker.commerce().price(10.00, 100.00)));
			}

			StoreControl storeControl = new StoreControl();
			storeControl.setAeropuertoId(airport.get(faker.number().numberBetween(0, 4)));
			storeControl.setPaymentDate(faker.date().between(before.getTime(), Calendar.getInstance().getTime()));
			storeControl.setStoreId(faker.bothify("??##"));
			storeControl.setSpend(spend);
			storeService.add(storeControl);
			spend.clear();

		}

	}


}
