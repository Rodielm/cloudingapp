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

import es.uv.twcam.cloudingapi.entities.Reservation;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.ReservationAssembler;

/**
 * ReservationCtrl
 */
public class ReservationCtrl {


    @Autowired
    private EntityService<Reservation> reservationService;

    ReservationAssembler assembler;

    ReservationCtrl(ReservationAssembler assembler) {
        this.assembler = assembler;
    }

    // Get /airplane
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<Reservation>> airplanes = reservationService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return reservationService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation add(@RequestBody Reservation Reservation) {
        return reservationService.save(Reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Integer id, @RequestBody Reservation entity) {
        Reservation reservation = new Reservation();
        reservation = entity;
        reservation.setId(id);
        return reservation;
    }

    @DeleteMapping
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.delete(id);
    }
    
}