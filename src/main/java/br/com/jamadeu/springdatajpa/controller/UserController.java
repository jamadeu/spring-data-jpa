package br.com.jamadeu.springdatajpa.controller;

import br.com.jamadeu.springdatajpa.model.User;
import br.com.jamadeu.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Jean Amadeu 08/12/2020
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        throw new IllegalArgumentException("User not found");
    }

    @GetMapping(value = "/domain/{domain}")
    public ResponseEntity<?> findByDomain(@PathVariable String domain){
        return new ResponseEntity<>(userRepository.findByEmailEndingWith(domain), HttpStatus.OK);
    }

    @GetMapping(value = "/domain_query/{domain}")
    public ResponseEntity<?> findByDomainQuery(@PathVariable String domain){
        return new ResponseEntity<>(userRepository.findByDomain(domain), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        Optional<User> user = userRepository.findByName(name);
        if(user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        throw new IllegalArgumentException("User not found");
    }

}
