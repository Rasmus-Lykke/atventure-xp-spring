package com.example.atventurexp_spring.Service;

import com.example.atventurexp_spring.Repository.BookingJpaRepo;
import com.example.atventurexp_spring.Repository.BookingRepo;
import com.example.atventurexp_spring.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingJpaRepo BookingRepo;

    public Booking addEvent(Booking booking){
        return BookingRepo.save(booking);
    }

}
