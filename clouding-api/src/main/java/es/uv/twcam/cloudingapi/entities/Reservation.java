package es.uv.twcam.cloudingapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Reservation
 */
@Data
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 3801427400685603012L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  

    @Column(name = "reservation_date")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    @Column(name = "luggages")
    private Integer luggages;

    @Column(name = "priority")
    private Boolean priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JsonIgnoreProperties("user")
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("passenger")
    private Passenger passenger;

    @ManyToOne
    @JsonIgnoreProperties("flight")
    private Flight flight;

} 