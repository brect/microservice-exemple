package com.blimas.hrworker.resource;

import com.blimas.hrworker.entities.Worker;
import com.blimas.hrworker.repository.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private final WorkerRepository repository;

    public WorkerResource(WorkerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable UUID id) {
        Worker worker = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker request) {
        Worker worker = repository.save(request);
        return ResponseEntity.ok(worker);
    }
}
