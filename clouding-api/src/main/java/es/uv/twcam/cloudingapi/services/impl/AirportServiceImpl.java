package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.Airport;
import es.uv.twcam.cloudingapi.repositories.AirportRepo;
import es.uv.twcam.cloudingapi.services.EntityService;


/**
 * AirportServiceImpl
 */

@Service
@Transactional
public class AirportServiceImpl implements EntityService<Airport> {
 
    @Autowired
    private AirportRepo airportRepo;

    @Override
    public List<Airport> getAll() {
        return airportRepo.findAll();
    }

  
    @Override
    public void delete(Integer id) {
        airportRepo.deleteById(id);
    }

    @Override
    public Airport save(Airport entity) {
        return airportRepo.save(entity);
    }

    @Override
    public Optional<Airport> findById(Integer id) {
        return airportRepo.findById(id);
    }

    
}