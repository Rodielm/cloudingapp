package es.uv.twcam.cloudingapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Airport
 */
@Data
@Entity
public class Airport implements Serializable {

    private static final long serialVersionUID = 5727521571625429418L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}