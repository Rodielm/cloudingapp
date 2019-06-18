package es.uv.twcam.cloudingapi.services;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassengersPriorityDTO implements Serializable {
	
	private static final long serialVersionUID = -3748933256798614249L;

	private String id;
	
	private String name;
	
	private String lastname;
	
	private Integer times_priority;
	
	public PassengersPriorityDTO(String id, String name, String lastname, Integer times_priority) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.times_priority = times_priority;
	}
	

	

}
