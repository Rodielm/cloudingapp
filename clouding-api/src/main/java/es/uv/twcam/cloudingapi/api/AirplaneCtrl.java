package es.uv.twcam.cloudingapi.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.twcam.cloudingapi.entities.Airplane;

import es.uv.twcam.cloudingapi.services.EntityService;


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


// Get /airplane
@GetMapping
public List<Airplane> getAll() {
    return airplaneService.getAll();
}

@GetMapping("/{id}")
public Airplane getById(@PathVariable("id") Integer id ) {
    return airplaneService.findById(id);
}

@PostMapping
public Airplane addAirplane(@RequestBody Airplane airplane){
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