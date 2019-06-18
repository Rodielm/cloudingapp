package es.uv.twcam.cloudingapi.services.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.AirportCtrl;
import es.uv.twcam.cloudingapi.entities.Airport;

/**
 * ServiceResourceAssembler
 */

@Component
public class AirportAssembler implements ResourceAssembler<Airport, Resource<Airport>> {

    @Override
    public Resource<Airport> toResource(Airport airport) {
        return new Resource<>(airport,
        linkTo(methodOn(AirportCtrl.class).getById(airport.getId())).withSelfRel(),
        linkTo(methodOn(AirportCtrl.class).getAll()).withRel("Airport"));
    }

}