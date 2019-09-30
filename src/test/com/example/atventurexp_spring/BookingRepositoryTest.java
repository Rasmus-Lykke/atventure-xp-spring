package com.example.atventurexp_spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookingRepositoryTest {

//    @Autowired
//    BookingRepository bookingRepository;
//
//    @Test
//    public void testBookingRepository() {
//        Booking bookingToDB = new Booking();
//        bookingToDB.setActivity(1);
//        bookingToDB.setPersons(1);
//        bookingToDB.setDate("2019-02-01 17:30");
//
//        bookingRepository.save(bookingToDB);
//
//        Booking bookingFromDB = bookingRepository.getById(bookingToDB.getId());
//
//        assertThat(bookingFromDB.getId()).isEqualTo(bookingToDB.getId());
//        assertThat(bookingFromDB.getActivity()).isEqualTo(1);
//        assertThat(bookingFromDB.getPersons()).isEqualTo(1);
//        assertThat(bookingFromDB.getDate()).isEqualTo(new Date("2019-02-01 17:30"));

//    }
}
