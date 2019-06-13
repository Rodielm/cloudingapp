package es.uv.twcam.cloudingapi.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Passenger
 */
@Data
@Entity
public class Passenger implements Serializable {

    private static final long serialVersionUID = -2604318260209507692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;

    @Size(max = 45)
    @Column(name = "lastname", length = 45)
    private String lastname;

    @OneToMany(mappedBy = "passenger")
    private Set<Reservation> reservationPassengers = new HashSet<>();


}