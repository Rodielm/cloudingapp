package es.uv.twcam.cloudingapi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Flight
 */

@Data
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = -7257564096665643288L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "takeoff_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeoffDate;


    @Column(name = "arrival_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JsonIgnoreProperties("airplane")
    private Airplane airplane;

    @OneToMany(mappedBy = "flight")
    @JsonIgnoreProperties("reservation")
    private Set<Reservation> reservations = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("takeoff")
    private Airport takeoff;

    @ManyToOne
    @JsonIgnoreProperties("arrival")
    private Airport arrival;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "status")
    private boolean status;
    
}