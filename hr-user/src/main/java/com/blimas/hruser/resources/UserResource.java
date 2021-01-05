package com.blimas.hruser.resources;

import com.blimas.hruser.entities.User;
import com.blimas.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private static Logger logger = LoggerFactory.getLogger(UserResource.class);

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> searchBy(@RequestParam String request) {
        User user = repository.findByEmail(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createWorker(@RequestBody User request) {
        User user =repository.save(request);
        return ResponseEntity.ok(user);
    }
}