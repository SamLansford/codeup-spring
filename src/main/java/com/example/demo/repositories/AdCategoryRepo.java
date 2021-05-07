package com.example.demo.repositories;


import com.example.demo.models.AdCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCategoryRepo extends JpaRepository<AdCategory, Long> {
}