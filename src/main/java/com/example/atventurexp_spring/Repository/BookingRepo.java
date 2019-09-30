package com.example.atventurexp_spring.Repository;

import com.example.atventurexp_spring.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Date;

@Repository
public class BookingRepo {
    @Autowired
    JdbcTemplate template;

    public Booking addEvent(Booking booking){
        String sql = "INSERT INTO booking (activityID, participants, date, contactName, contactPhone, contactEmail) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, booking.getActivityID(), booking.getParticipants(), booking.getDate(), booking.getContactName(), booking.getContactPhone(), booking.getContactEmail());
        return null;
    }



    public List<Booking> fetchAll (){
        String sql = "SELECT * FROM Booking";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }




}
