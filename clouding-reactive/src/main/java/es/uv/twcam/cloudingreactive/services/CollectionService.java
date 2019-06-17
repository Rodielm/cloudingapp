package es.uv.twcam.cloudingreactive.services;

import org.bson.types.ObjectId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CollectionService
 */
public interface CollectionService<T> {

Flux<T> findAll();

Mono<T> findById(ObjectId id);

Mono<T> save(T e);

Mono<T> add(T e);

Mono<Void> delete(ObjectId id);

Mono<Void> deleteAll();
    
}