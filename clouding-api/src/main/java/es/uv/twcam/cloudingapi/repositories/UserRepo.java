package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uv.twcam.cloudingapi.entities.User;

/**
 * User
 */


public interface UserRepo extends JpaRepository<User,Integer > {

    
}