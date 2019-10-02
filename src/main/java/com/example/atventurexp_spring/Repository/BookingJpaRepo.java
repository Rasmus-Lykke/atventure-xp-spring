package com.example.atventurexp_spring.Repository;

import com.example.atventurexp_spring.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpaRepo extends JpaRepository<Booking, Long> {
}
