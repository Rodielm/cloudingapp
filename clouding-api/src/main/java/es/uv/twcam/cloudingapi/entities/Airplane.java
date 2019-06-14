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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column
    private String number;

    @Column
    private Integer capacity;

    @OneToMany
    @JsonIgnoreProperties
    private Set<Flight> Flights = new HashSet<>();
    
}