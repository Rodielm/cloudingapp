package es.uv.twcam.cloudingreactive.services.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import es.uv.twcam.cloudingreactive.collection.AirportControl;
import es.uv.twcam.cloudingreactive.repositories.AirportControlRepository;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * AirportControlImpl
 */
public class AirportControlImpl implements CollectionService<AirportControl> {

    @Autowired
    AirportControlRepository airportControlRepo;

    @Override
    public Flux<AirportControl> findAll() {
        return airportControlRepo.findAll();
    }

    @Override
    public Mono<AirportControl> findById(ObjectId id) {
        return airportControlRepo.findById(id);
    }

    @Override
    public Mono<AirportControl> save(AirportControl e) {
        return airportControlRepo.save(e);
    }

    @Override
    public Mono<AirportControl> add(AirportControl e) {
        return airportControlRepo.save(e);
    }

    @Override
    public Mono<Void> delete(ObjectId id) {
        return airportControlRepo.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return airportControlRepo.deleteAll();
    }

    
}