package com.example.atventurexp_spring.Controller;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewBookingController {
@Autowired
BookingService bookingService;


    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable("id") long bookingID){
        bookingService.deleteBooking(bookingID);
        return "redirect:/";
    }
}
