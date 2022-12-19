package com.example.exambackend.repository;

import com.example.exambackend.model.Van;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VanRepository extends JpaRepository<Van, Long> {
}
