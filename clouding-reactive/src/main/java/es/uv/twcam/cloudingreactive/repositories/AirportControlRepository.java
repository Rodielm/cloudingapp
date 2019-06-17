package es.uv.twcam.cloudingreactive.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import es.uv.twcam.cloudingreactive.collection.AirportControl;

/**
 * AirportControlRepository
 */
public interface AirportControlRepository extends ReactiveMongoRepository<AirportControl,ObjectId> {

    
}