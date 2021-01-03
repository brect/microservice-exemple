package com.blimas.hrworker.resource;

import com.blimas.hrworker.entities.Worker;
import com.blimas.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private final WorkerRepository repository;

    private final Environment env;

    public WorkerResource(WorkerRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable UUID id) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker request) {
        Worker worker = repository.save(request);
        return ResponseEntity.ok(worker);
    }
}
