package es.uv.twcam.cloudingreactive.collection;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * AirportControl
 */

@Document(collection = "airportcontrol")
@TypeAlias("airportcontrol")
@Data
public class AirportControl {

    private Integer reservationId;
    private String airportStart;
    private String airportEnd;
    private Date boarding;
    private Date securityCheck;
    private String gate;
    
}