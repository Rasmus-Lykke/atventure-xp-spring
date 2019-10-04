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


public class UpdateBooking_Test {

    @Autowired
    BookingJpaRepo bookingRepo;
    @Autowired
    BookingService bookingService;

    AddBooking_Test addBooking_test = new AddBooking_Test();

    Booking updateBooking = new Booking();
    Booking getBooking = new Booking();
    Booking createBooking = new Booking();


    @Test
    public void UpdateBookingTest(){


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


        addBooking_test.addBookingTest();

        updateBooking.setBookingID(1L);
        updateBooking.setActivityID(2L);
        updateBooking.setParticipants(2);
        updateBooking.setDate("10-10-1010");
        updateBooking.setTime("10:00");
        updateBooking.setContactName("Test Test");
        updateBooking.setContactPhone("10101010");
        updateBooking.setContactEmail("TestTest@gmail.com");
        updateBooking.setInstructor("TestTest");
        updateBooking.setCorporate("TestTest");


        bookingService.updateByID(updateBooking);

        getBooking = bookingRepo.getOne(1L);

        long actualBookingID = getBooking.getBookingID();
        assertThat(actualBookingID).isEqualTo(1);

        long actualActivityID = getBooking.getActivityID();
        assertThat(actualActivityID).isEqualTo(2);


    }
}
