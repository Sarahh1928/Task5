package com.example.hotel.BookingService.Controllers;

import com.example.hotel.BookingService.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService service;

    @Value("${Name}")
    private String name;

    @Value("${ID}")
    private String id;
    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public String book(@RequestParam String roomType, @RequestParam int nights) {
        return service.createBooking(roomType, nights)+"_"+name+"_"+id;
    }
}

