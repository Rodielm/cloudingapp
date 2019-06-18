package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.ReservationCtrl;
import es.uv.twcam.cloudingapi.entities.Reservation;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * ServiceResourceAssembler
 */

@Component
public class ReservationAssembler implements ResourceAssembler<Reservation, Resource<Reservation>> {

    @Override
    public Resource<Reservation> toResource(Reservation Reservation) {
        return new Resource<>(Reservation,
        linkTo(methodOn(ReservationCtrl.class).getById(Reservation.getId())).withSelfRel(),
        linkTo(methodOn(ReservationCtrl.class).getAll()).withRel("Reservations"));
    }

}