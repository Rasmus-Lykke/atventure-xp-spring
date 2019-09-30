package com.example.atventurexp_spring.Controller;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Repository.BookingRepo;
import com.example.atventurexp_spring.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/BookEvent")
    public String BookEvent(){
        return "BookEvent.html";
    }

    @PostMapping("/BookEvent")
    public String addEvent(@ModelAttribute Booking booking) {
        bookingService.addEvent(booking);
        return "redirect:/";
    }

package main.java.com.example.atventurexp_spring.Controller;

public class BookingController {
}
