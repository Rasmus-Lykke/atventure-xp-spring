package com.example.atventurexp_spring.Service;

import com.example.atventurexp_spring.Repository.BookingJpaRepo;
import com.example.atventurexp_spring.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingJpaRepo bookingRepo;

    public Booking addEvent(Booking booking){
        return bookingRepo.save(booking);
    }

    public void deleteBooking(long bookingID){
        bookingRepo.deleteById(bookingID);
    }

    public boolean existsById(long id){
        return bookingRepo.existsById(id);
    }

    public Booking getById(Long id){
        return bookingRepo.getOne(id);
    }

}
