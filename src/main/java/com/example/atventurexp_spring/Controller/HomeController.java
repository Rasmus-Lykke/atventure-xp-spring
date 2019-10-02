package com.example.atventurexp_spring.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "Home.html";
    }

    @GetMapping("/ViewBookingEquip")
    public String BookingOversigt(Model model){
        return "ViewBookingEquip.html";
    }
}
