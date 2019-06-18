package es.uv.twcam.cloudingapi.api;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import es.uv.twcam.cloudingapi.entities.Airport;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.AirportAssembler;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * AirportCtrl
 */
public class AirportCtrl {


      // Get /Airport/{id}
    // Put /Airport/{id}
    // Post /Airport/

    @Autowired
    private EntityService<Airport> airportService;

    AirportAssembler assembler;

    AirportCtrl(AirportAssembler assembler) {
        this.assembler = assembler;
    }

    // Get /Airport
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<Airport>> Airports = airportService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(Airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return airportService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport Airport) {
        return airportService.save(Airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Integer id, @RequestBody Airport entity) {
        Airport Airport = new Airport();
        Airport = entity;
        Airport.setId(id);
        return Airport;
    }

    @DeleteMapping
    public void deleteAirport(@PathVariable Integer id) {
        airportService.delete(id);
    }
    
}