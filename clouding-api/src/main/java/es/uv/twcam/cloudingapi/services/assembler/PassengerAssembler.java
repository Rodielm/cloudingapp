package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.PassengerCtrl;
import es.uv.twcam.cloudingapi.entities.Passenger;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * ServiceResourceAssembler
 */

@Component
public class PassengerAssembler implements ResourceAssembler<Passenger, Resource<Passenger>> {

    @Override
    public Resource<Passenger> toResource(Passenger Passenger) {
        return new Resource<>(Passenger,
        linkTo(methodOn(PassengerCtrl.class).getById(Passenger.getId())).withSelfRel(),
        linkTo(methodOn(PassengerCtrl.class).getAll()).withRel("Passengers"));
    }

}