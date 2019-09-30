package com.example.atventurexp_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home(Model model){
        return "Home.html";
    }

    @GetMapping("/ViewBookingEquip")
    public String BookingOversigt(Model model){
        return "ViewBookingEquip.html";
    }
}
