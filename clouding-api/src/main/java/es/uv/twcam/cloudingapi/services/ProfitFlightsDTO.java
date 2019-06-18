package es.uv.twcam.cloudingapi.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfitFlightsDTO {

	private String municipality;
	
	private String continent;
	
	private Integer airport_arrival;
	
	private double payment;
	
	public ProfitFlightsDTO(String nunicipality, String continent, Integer airport_arrival, double payment) {
		super();
		this.municipality = nunicipality;
		this.continent = continent;
		this.airport_arrival = airport_arrival;
		this.payment = payment;
	}
	

}

