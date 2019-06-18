package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.Airplane;
import es.uv.twcam.cloudingapi.repositories.AirplaneRepo;
import es.uv.twcam.cloudingapi.services.EntityService;


/**
 * AirportServiceImpl
 */

@Service
@Transactional
public class AirplaneServiceImpl implements EntityService<Airplane> {
 
    @Autowired
    private AirplaneRepo airplaneRepo;

    @Override
    public List<Airplane> getAll() {
        return airplaneRepo.findAll();
    }

  
    @Override
    public void delete(Integer id) {
        airplaneRepo.deleteById(id);
    }

    @Override
    public Airplane save(Airplane entity) {
        return airplaneRepo.save(entity);
    }

    @Override
    public Optional<Airplane> findById(Integer id) {
        return airplaneRepo.findById(id);
    }

    
}