package es.uv.twcam.cloudingapi.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.twcam.cloudingapi.entities.User;
import es.uv.twcam.cloudingapi.services.EntityService;
import es.uv.twcam.cloudingapi.services.assembler.UserAssembler;

/**
 * UserCtrl
 */


@RestController
@RequestMapping("/api/user")
public class UserCtrl {

    @Autowired
    private EntityService<User> userService;

    UserAssembler assembler;

    UserCtrl(UserAssembler assembler) {
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Resource<User>> Users = userService.getAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        
        return userService.findById(id)
        .map(assembler::toResource)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User addUser(@RequestBody User User) {
        return userService.save(User);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User entity) {
        User User = new User();
        User = entity;
        User.setId(id);
        return User;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    
}