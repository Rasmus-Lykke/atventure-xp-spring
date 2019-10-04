package com.example.atventurexp_spring.Controller;

import com.example.atventurexp_spring.Model.Activity;
import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Service.ActivityService;
import com.example.atventurexp_spring.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    ActivityService activityService;

    @GetMapping("/BookEvent")
    public String bookBooking(Model model){
        List<Activity> activityList = activityService.getAllActivities();
        model.addAttribute("activityList", activityList);
        return "BookEvent.html";
    }

    @PostMapping("/BookEvent")
    public String addBooking(@ModelAttribute Booking booking) {
        bookingService.addBooking(booking);
        return "redirect:/";
    }




    @PostMapping("/UpdateBooking")
    public String updateBooking(@ModelAttribute Booking booking) {
        bookingService.updateByID(booking);
        return "redirect:/";
    }

    @GetMapping("/UpdateBooking")
    public String updateBooking(){
        return "UpdateBooking.html";
    }



    @GetMapping("/UpdateBookingByID/{bookingID}")
    public String updateBookingByID(@PathVariable("bookingID") long bookingID) {
        bookingService.getById(bookingID);
        return "UpdateBookingByID.html";
    }

    @GetMapping("/UpdateBookingByID")
    public String updateBookingByID(Long bookingID) {
        bookingService.getById(bookingID);
        return "UpdateBookingByID.html";
    }


    @PostMapping("/SaveUpdateBookingByID")
    public String saveUpdateBookingByID(@ModelAttribute Booking booking) {
        bookingService.updateByID(booking);
        return "redirect:/";
    }


}
