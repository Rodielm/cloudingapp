package es.uv.twcam.cloudingreactive.api;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.twcam.cloudingreactive.collection.StoreControl;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StoreControlCtrl
 */

@RestController
@RequestMapping("/api/storecontrol")
public class StoreControlCtrl {


    @Autowired
    CollectionService<StoreControl> storeService;

    @GetMapping
    public Flux<StoreControl> getAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public  Mono<StoreControl> getById(@PathVariable ObjectId id){
        return storeService.findById(id);
    }

    @PutMapping()
    public Mono<StoreControl> update(@RequestBody StoreControl e) {
        return storeService.save(e);
    }

    @PostMapping()
    public Mono<StoreControl> addStoreControl(@RequestBody StoreControl ac) {
        return storeService.save(ac);
    }

    @DeleteMapping
    public void delete(@PathVariable ObjectId id){
        storeService.delete(id);
    }
    
}