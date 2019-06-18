package es.uv.twcam.cloudingreactive.services;

import org.bson.types.ObjectId;

import es.uv.twcam.cloudingreactive.collection.GateControlDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CollectionService
 */
public interface CollectionService<T> {

Flux<T> findAll();

Mono<T> findById(ObjectId id);

Mono<T> save(T e);

void add(T e);

Mono<Void> delete(ObjectId id);

Mono<Void> deleteAll();

Flux<GateControlDto> getAvgByAirport(String airpots);

Flux<GateControlDto> getAvgByGate(String gate, int year);



    
}