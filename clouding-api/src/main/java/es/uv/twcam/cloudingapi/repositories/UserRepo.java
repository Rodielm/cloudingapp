package es.uv.twcam.cloudingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.twcam.cloudingapi.entities.User;

/**
 * User
 */

@Repository
public interface UserRepo extends JpaRepository<User,Integer > {

   public User findByUsername(String username);
}