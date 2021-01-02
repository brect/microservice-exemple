package com.blimas.hrworker.repository;

import com.blimas.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
}
