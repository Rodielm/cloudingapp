package es.uv.twcam.cloudingapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.User;
import es.uv.twcam.cloudingapi.repositories.UserRepo;
import es.uv.twcam.cloudingapi.services.EntityService;

/**
 * UserServiceImpl
 */

@Service
@Transactional
public class UserServiceImpl implements EntityService<User> {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User save(User entity) {
        return userRepo.save(entity);
    }

}