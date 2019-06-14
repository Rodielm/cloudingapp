package es.uv.twcam.cloudingapi.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



/**
 * 
 * @param <T>
 */

@NoRepositoryBean
public interface GenericRepo<T, Id extends Serializable> extends JpaRepository<T,Id>{

    
}