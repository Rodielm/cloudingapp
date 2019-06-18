package es.uv.twcam.cloudingapi.services.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import es.uv.twcam.cloudingapi.api.UserCtrl;
import es.uv.twcam.cloudingapi.entities.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * UserAssembler
 */

@Component
public class UserAssembler implements ResourceAssembler<User, Resource<User>> {

    @Override
    public Resource<User> toResource(User user) {
        return new Resource<>(user,
        linkTo(methodOn(UserCtrl.class).getById(user.getId())).withSelfRel(),
        linkTo(methodOn(UserCtrl.class).getAll()).withRel("User"));
    }

}