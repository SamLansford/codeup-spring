package com.example.demo.repositories;

import com.example.demo.models.AdDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdDetailsRepo extends JpaRepository<AdDetails, Long> {
}