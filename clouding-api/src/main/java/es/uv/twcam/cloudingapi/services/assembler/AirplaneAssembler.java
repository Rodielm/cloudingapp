package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.AirplaneCtrl;
import es.uv.twcam.cloudingapi.entities.Airplane;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * ServiceResourceAssembler
 */

@Component
public class AirplaneAssembler implements ResourceAssembler<Airplane, Resource<Airplane>> {

    @Override
    public Resource<Airplane> toResource(Airplane airplane) {
        return new Resource<>(airplane,
        linkTo(methodOn(AirplaneCtrl.class).getById(airplane.getId())).withSelfRel(),
        linkTo(methodOn(AirplaneCtrl.class).getAll()).withRel("Airplanes"));
    }

}