package es.uv.twcam.cloudingreactive.services.impl;

import org.bson.types.ObjectId;

import es.uv.twcam.cloudingreactive.collection.AirportControl;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * AirportControlImpl
 */
public class AirportControlImpl implements CollectionService<AirportControl> {

    

    @Override
    public Flux<AirportControl> findAll() {
        return null;
    }

    @Override
    public Mono<AirportControl> findById(ObjectId id) {
        return null;
    }

    @Override
    public Mono<AirportControl> update(AirportControl e) {
        return null;
    }

    @Override
    public Mono<AirportControl> add(AirportControl e) {
        return null;
    }

    @Override
    public Mono<Void> delete(ObjectId id) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }

    
}