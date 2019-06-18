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

import es.uv.twcam.cloudingapi.entities.Passenger;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.PassengerAssembler;


/**
 * PassengerCtrl
 */
public class PassengerCtrl {


    @Autowired
    private EntityService<Passenger> passengerService;

    PassengerAssembler assembler;

    PassengerCtrl(PassengerAssembler assembler) {
        this.assembler = assembler;
    }

    // Get /airplane
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<Passenger>> airplanes = passengerService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return passengerService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger add(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Integer id, @RequestBody Passenger entity) {
        Passenger Passenger = new Passenger();
        Passenger = entity;
        Passenger.setId(id);
        return Passenger;
    }

    @DeleteMapping
    public void deletePassenger(@PathVariable Integer id) {
        passengerService.delete(id);
    }
    
}