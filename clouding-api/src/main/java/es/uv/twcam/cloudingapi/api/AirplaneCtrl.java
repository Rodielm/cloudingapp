package es.uv.twcam.cloudingapi.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.twcam.cloudingapi.entities.Airplane;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.AirplaneAssembler;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * AirplaneCtrl
 */

@RestController
@RequestMapping("/api/airplane")
public class AirplaneCtrl {

    // Get /airplane/{id}
    // Put /airplane/{id}
    // Post /airplane/

    @Autowired
    private EntityService<Airplane> airplaneService;

    AirplaneAssembler assembler;

    AirplaneCtrl(AirplaneAssembler assembler) {
        this.assembler = assembler;
    }

    // Get /airplane
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<Airplane>> airplanes = airplaneService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return airplaneService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Airplane addAirplane(@RequestBody Airplane airplane) {
        return airplaneService.save(airplane);
    }

    @PutMapping("/{id}")
    public Airplane updateAirplane(@PathVariable Integer id, @RequestBody Airplane entity) {
        Airplane airplane = new Airplane();
        airplane = entity;
        airplane.setId(id);
        return airplane;
    }

    @DeleteMapping
    public void deleteAirplane(@PathVariable Integer id) {
        airplaneService.delete(id);
    }

}