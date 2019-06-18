package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.AirplaneCtrl;
import es.uv.twcam.cloudingapi.api.FlightCtrl;
import es.uv.twcam.cloudingapi.entities.Airplane;
import es.uv.twcam.cloudingapi.entities.Flight;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * ServiceResourceAssembler
 */

@Component
public class FlightAssembler implements ResourceAssembler<Flight, Resource<Flight>> {

    @Override
    public Resource<Flight> toResource(Flight flight) {
        return new Resource<>(flight,
        linkTo(methodOn(FlightCtrl.class).getById(flight.getId())).withSelfRel(),
        linkTo(methodOn(FlightCtrl.class).getAll()).withRel("Flight"));
    }

}