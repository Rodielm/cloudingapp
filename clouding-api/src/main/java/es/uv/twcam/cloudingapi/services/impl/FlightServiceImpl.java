package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.Flight;
import es.uv.twcam.cloudingapi.repositories.FlightRepo;
import es.uv.twcam.cloudingapi.services.EntityService;


/**
 * AirportServiceImpl
 */

@Service
@Transactional
public class FlightServiceImpl implements EntityService<Flight> {
 
    @Autowired
    private FlightRepo FlightRepo;

    @Override
    public List<Flight> getAll() {
        return FlightRepo.findAll();
    }

  
    @Override
    public void delete(Integer id) {
        FlightRepo.deleteById(id);
    }

    @Override
    public Flight save(Flight entity) {
        return FlightRepo.save(entity);
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return FlightRepo.findById(id);
    }

    
}