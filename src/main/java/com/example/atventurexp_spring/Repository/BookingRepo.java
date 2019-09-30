package com.example.atventurexp_spring.Repository;

import com.example.atventurexp_spring.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class BookingRepo {
    @Autowired
    JdbcTemplate template;

    public void addEvent(Booking booking){
        String sql = "INSERT INTO booking (bookingID, activityID, participants, date, contactName, contactPhone, contactEmail, timeLimitID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, booking);
    }

}
