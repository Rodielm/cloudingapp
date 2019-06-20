package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.Passenger;
import es.uv.twcam.cloudingapi.repositories.PassengerRepo;
import es.uv.twcam.cloudingapi.services.EntityService;


/**
 * PassengerServiceImpl
 */

@Service
@Transactional
public class PassengerServiceImpl implements EntityService<Passenger> {
 
    @Autowired
    private PassengerRepo PassengerRepo;

    @Override
    public List<Passenger> getAll() {
        return PassengerRepo.findAll();
    }

  
    @Override
    public void delete(Integer id) {
        PassengerRepo.deleteById(id);
    }

    @Override
    public Passenger save(Passenger entity) {
        return PassengerRepo.save(entity);
    }

    @Override
    public Optional<Passenger> findById(Integer id) {
        return PassengerRepo.findById(id);
    }

    
}