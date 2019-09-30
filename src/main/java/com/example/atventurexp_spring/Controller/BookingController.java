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

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/BookEvent")
    public String BookEvent() {
        return "BookEvent.html";
    }

    @PostMapping("/BookEvent")
    public String addEvent(@ModelAttribute Booking booking) {
        bookingService.addEvent(booking);
        return "redirect:/";
    }

    @GetMapping ("/BookingInfo")
    public String bookingRepo (Booking booking){
        List<Booking> bookingList = BookingService.fetchAll();

        return "BookingInfo.html";
    }

}
