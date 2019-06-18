package es.uv.twcam.cloudingreactive.services.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import es.uv.twcam.cloudingreactive.collection.AirportControl;
import es.uv.twcam.cloudingreactive.collection.GateControlDto;
import es.uv.twcam.cloudingreactive.repositories.AirportControlRepository;
import es.uv.twcam.cloudingreactive.services.CollectionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * AirportControlImpl
 */

@Service
public class AirportControlImpl implements CollectionService<AirportControl> {

    @Autowired
    AirportControlRepository airportControlRepo;

    @Autowired
    ReactiveMongoTemplate rmongo;


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
    public void add(AirportControl e) {
        airportControlRepo.save(e).subscribe();
    }

    @Override
    public Mono<Void> delete(ObjectId id) {
        return airportControlRepo.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return airportControlRepo.deleteAll();
    }

    @Override
    public Flux<GateControlDto> getAvgByAirport(String airpots) {

        // MatchOperation match = Aggregation.match(new Criteria().andOperator(
        // Criteria.where("airportStart").is(airpotStart),
        // Criteria.where("airportEnd").is(airportEnd)));

        ProjectionOperation project = Aggregation.project("airportStart").and("boarding").extractYear().as("year")
                .andExpression("(boarding - securityCheck)/[0]", 60000).as("avgTime");

        GroupOperation group = Aggregation.group("airportStart", "year").avg("avgTime").as("avgTime");

        Aggregation aggregation = Aggregation.newAggregation(project, group);

        return rmongo.aggregate(aggregation, "airportcontrol", GateControlDto.class);
    }

    @Override
    public Flux<GateControlDto> getAvgByGate(String gate, int year) {
        Criteria cri = new Criteria();
        cri.andOperator(Criteria.where("gate").is(gate), Criteria.where("boarding").is(year));

        ProjectionOperation project = Aggregation.project("gate").and("boarding").extractYear().as("year")
                .andExpression("(boarding - securityCheck)/[0]", 60000).as("avgTime");

        // ("boarding").minus("securityCheck").as("avgTime").and("avgTime").divide(6000).as("avgTime");
        // MatchOperation match = Aggregation.match(cri);

        GroupOperation group = Aggregation.group("gate", "year").avg("avgTime").as("avgTime");

        Aggregation aggregation = Aggregation.newAggregation(project, group);

        return rmongo.aggregate(aggregation, "airportcontrol", GateControlDto.class);
    }



    
}