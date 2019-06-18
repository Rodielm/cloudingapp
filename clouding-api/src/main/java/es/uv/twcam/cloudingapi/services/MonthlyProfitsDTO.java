package es.uv.twcam.cloudingapi.services;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonthlyProfitsDTO {
	
	private int year;
	private int  month;
	private double profits;


	public MonthlyProfitsDTO(int year, int month, double profits) {
		super();
		this.year = year;
		this.month = month;
		this.profits = profits;
	}


}
