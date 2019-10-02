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

        bookingExistsResult = bookingService.existsById(1L);

        assertThat(bookingExistsResult).isEqualTo(false);

        booking.setActivityID(1L);
        booking.setContactEmail("test@gmail.com");
        booking.setContactName("Test");
        booking.setContactPhone("00000000");
        booking.setDate("01");
        booking.setParticipants(1);

        bookingService.addEvent(booking);

        bookingExistsResult = bookingService.existsById(1L);
        assertThat(bookingExistsResult).isEqualTo(true);

        bookingService.deleteBooking(1L);
        boolean actualResult = bookingService.existsById(1L);
        assertThat(actualResult).isEqualTo(false);


    }



}
