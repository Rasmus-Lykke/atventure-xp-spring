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
public class AddBooking_Test {

    @Autowired
    BookingJpaRepo bookingRepo;
    @Autowired
    BookingService bookingService;
    Booking createBooking = new Booking();



    @Test
    public void addBookingTest(){

        boolean bookingExistsResult;

        bookingExistsResult = bookingRepo.existsById(1L);
        assertThat(bookingExistsResult).isEqualTo(false);

        createBooking.setActivityID(1L);
        createBooking.setParticipants(1);
        createBooking.setDate("20-20-2020");
        createBooking.setTime("20:00");
        createBooking.setContactName("Test");
        createBooking.setContactPhone("20202020");
        createBooking.setContactEmail("Test@gmail.com");
        createBooking.setInstructor("Test");
        createBooking.setCorporate("Test");


        // Send to DB
        bookingService.addBooking(createBooking);

        // lav check om det eksistere!

        bookingExistsResult = bookingRepo.existsById(1L);
        assertThat(bookingExistsResult).isEqualTo(true);
    }
}
