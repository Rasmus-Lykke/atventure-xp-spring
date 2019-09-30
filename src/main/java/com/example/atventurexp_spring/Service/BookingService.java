package com.example.atventurexp_spring.Service;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService {
    @Autowired
    BookingRepo BookingRepo;

    public Booking addEvent(Booking booking){
        return BookingRepo.addEvent(booking);
    }

package main.java.com.example.atventurexp_spring.Service;

public class BookingService {
}
