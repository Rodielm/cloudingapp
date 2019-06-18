package es.uv.twcam.cloudingapi.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.uv.twcam.cloudingapi.entities.Flight;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.FlightAssembler;

/**
 * FlightCtrl
 */
public class FlightCtrl {


    @Autowired
    private EntityService<Flight> flightService;

    FlightAssembler assembler;

    FlightCtrl(FlightAssembler assembler) {
        this.assembler = assembler;
    }

    // Get /airplane
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<Flight>> airplanes = flightService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return flightService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight entity) {
        Flight flight = new Flight();
        flight = entity;
        flight.setId(id);
        return flight;
    }

    @DeleteMapping
    public void deleteFlight(@PathVariable Integer id) {
        flightService.delete(id);
    }
    
}