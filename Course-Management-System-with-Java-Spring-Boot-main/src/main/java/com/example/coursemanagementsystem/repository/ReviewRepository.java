package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
