package com.example.demo.repositories;

import com.example.demo.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepo extends JpaRepository<Ad, Long> {

}
