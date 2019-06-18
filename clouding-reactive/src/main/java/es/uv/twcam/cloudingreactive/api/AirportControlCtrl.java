package es.uv.twcam.cloudingreactive.api;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uv.twcam.cloudingreactive.collection.AirportControl;
import es.uv.twcam.cloudingreactive.collection.GateControlDto;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestBody;


/**
 * AirportControlCtrl
 */
@RestController
@RequestMapping("/api/airportcontrol")
public class AirportControlCtrl {

    @Autowired
    CollectionService<AirportControl> airportService;

    

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AirportControl> getAll(){
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public  Mono<AirportControl> getById(@PathVariable ObjectId id){
        return airportService.findById(id);
    }

    @PutMapping()
    public Mono<AirportControl> update(@RequestBody AirportControl e) {
        return airportService.save(e);
    }

    @PostMapping()
    public Mono<AirportControl> addAirportControl(@RequestBody AirportControl ac) {
        return airportService.save(ac);
    }

    @DeleteMapping
    public void delete(@PathVariable ObjectId id){
        airportService.delete(id);
    }
    

    @GetMapping(path = "/{airport}/year", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<GateControlDto> getAvgByGate(@PathVariable("airport") String airport) {
        Flux<GateControlDto> emps = airportService.getAvgByAirport(airport);
        return emps;
    }

    @GetMapping(path = "/gate/{gate}/year/{year}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<GateControlDto> getAvgByGate(@PathVariable("gate") String gate, @PathVariable("year") int year) {
        Flux<GateControlDto> emps = airportService.getAvgByGate(gate, year);
        return emps;
    }

}