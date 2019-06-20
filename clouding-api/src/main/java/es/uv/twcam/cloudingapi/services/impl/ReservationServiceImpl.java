package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.Reservation;
import es.uv.twcam.cloudingapi.repositories.ReservationRepo;
import es.uv.twcam.cloudingapi.services.EntityService;

/**
 * ReservationServiceImpl
 */
@Service
@Transactional
public class ReservationServiceImpl implements EntityService<Reservation> {

    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }

  
    @Override
    public void delete(Integer id) {
        reservationRepo.deleteById(id);
    }

    @Override
    public Reservation save(Reservation entity) {
        return reservationRepo.save(entity);
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationRepo.findById(id);
    }
    
}