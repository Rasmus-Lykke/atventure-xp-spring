package com.example.atventurexp_spring.Controller;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Model.Equipment;
import com.example.atventurexp_spring.Service.ActivityService;
import com.example.atventurexp_spring.Service.BookingService;
import com.example.atventurexp_spring.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    BookingService bookingService;


    @GetMapping("/")
    public String root() {
        return "Home.html";
    }

    @GetMapping("/ViewBooking/{id}")
    public String BookingOversigt(Model model, @PathVariable Long id) {
        Booking booking = bookingService.getById(id);
        model.addAttribute("booking", booking);
        List<Equipment> equipmentList = equipmentService.getEquipmentListByActivity(booking.getActivityID());
        model.addAttribute("equipmentList", equipmentList);

        return "ViewBooking.html";
    }

}
