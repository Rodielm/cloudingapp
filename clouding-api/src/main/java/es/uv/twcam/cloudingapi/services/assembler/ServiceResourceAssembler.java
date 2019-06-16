package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.entities.Airplane;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * ServiceResourceAssembler
 */

@Component
public class ServiceResourceAssembler implements ResourceAssembler<Airplane, Resource<Airplane>> {

    @Override
    public Resource<Airplane> toResource(Airplane entity) {
        return null;
    }

}