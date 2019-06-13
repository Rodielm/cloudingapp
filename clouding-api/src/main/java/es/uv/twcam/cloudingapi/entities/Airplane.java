package es.uv.twcam.cloudingapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Airplane
 */

@Data
@Entity
public class Airplane implements Serializable {
    private static final long serialVersionUID = 4252534497213263832L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ident")
    @Size(max = 100)
    private String ident;

    @Column(name = "airport_type")
    @Size(max = 200)
    private String typeAirport;

    @Column(name = "airport_name")
    @Size(max = 200)
    private String airportName;

    @Column(nullable = true, name = "elevation_ft")
    private Integer elevationFt;

    @Column(name = "continent")
    @Size(max = 20)
    private String continent;

    @Column(name = "iso_country")
    @Size(max = 20)
    private String isoCountry;

    @Column(name = "iso_region")
    @Size(max = 100)
    private String isoRegion;

    @Column(name = "municipality")
    @Size(max = 200)
    private String municipality;

    @Column(name = "gps_code")
    @Size(max = 40)
    private String gpsCode;

    @Column(name = "iata_code", nullable = true)
    @Size(max = 100)
    private String iataCode;

    @Column(name = "local_code")
    @Size(max = 100)
    private String localCode;

    @Column(name = "coordinates")
    private String coordinates;


    
}