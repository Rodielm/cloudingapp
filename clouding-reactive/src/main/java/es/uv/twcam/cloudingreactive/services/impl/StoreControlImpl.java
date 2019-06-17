package es.uv.twcam.cloudingreactive.services.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import es.uv.twcam.cloudingreactive.collection.StoreControl;
import es.uv.twcam.cloudingreactive.repositories.StoreControlRepository;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CollectionServiceImpl
 */
public class StoreControlImpl implements CollectionService<StoreControl> {

    @Autowired
    StoreControlRepository storeControlRepository;

    @Override
    public Flux<StoreControl> findAll() {
        return storeControlRepository.findAll();
    }

    @Override
    public Mono<StoreControl> findById(ObjectId id) {
        return storeControlRepository.findById(id);
    }

    @Override
    public Mono<StoreControl> update(StoreControl e) {
        return storeControlRepository.save(e);
    }

    @Override
    public Mono<StoreControl> add(StoreControl e) {
        return storeControlRepository.save(e);
    }

    @Override
    public Mono<Void> delete(ObjectId id) {
        return storeControlRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return storeControlRepository.deleteAll();
    }

}