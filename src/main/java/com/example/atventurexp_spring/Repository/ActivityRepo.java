package com.example.atventurexp_spring.Repository;

import com.example.atventurexp_spring.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
