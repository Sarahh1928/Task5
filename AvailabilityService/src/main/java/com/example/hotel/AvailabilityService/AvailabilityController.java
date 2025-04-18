package com.example.hotel.AvailabilityService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @GetMapping("/check/{roomType}/{nights}")
    public boolean check(
            @PathVariable String roomType,
            @PathVariable int nights
    ) {
        // e.g. only "DOUBLE" rooms allowed, max 5 nights
        return "DOUBLE".equalsIgnoreCase(roomType) && nights <= 5;
    }
}

