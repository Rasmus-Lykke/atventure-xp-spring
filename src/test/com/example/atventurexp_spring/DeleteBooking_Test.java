package com.example.atventurexp_spring;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Repository.BookingJpaRepo;
import com.example.atventurexp_spring.Service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureTestDatabase
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteBooking_Test {

    @Autowired
    BookingJpaRepo bookingRepo;
    @Autowired
    BookingService bookingService;

    Booking booking = new Booking();


    @Test
    public void DeleteBookingTest() {


        boolean bookingExistsResult;

        bookingExistsResult = bookingRepo.existsById(1L);
        assertThat(bookingExistsResult).isEqualTo(false);

        booking.setActivityID(1L);
        booking.setParticipants(1);
        booking.setDate("20-20-2020");
        booking.setTime("20:00");
        booking.setContactName("Test");
        booking.setContactPhone("20202020");
        booking.setContactEmail("Test@gmail.com");
        booking.setInstructor("Test");
        booking.setCorporate("Test");


        // Send to DB
        bookingService.addBooking(booking);

        // lav check om det eksistere!

        bookingExistsResult = bookingRepo.existsById(1L);
        assertThat(bookingExistsResult).isEqualTo(true);


        bookingService.deleteBooking(1L);

        boolean actualResult = bookingRepo.existsById(1L);
        assertThat(actualResult).isEqualTo(false);


    }



}
