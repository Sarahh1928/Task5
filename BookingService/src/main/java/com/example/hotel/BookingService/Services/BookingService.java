package com.example.hotel.BookingService.Services;

import com.example.hotel.BookingService.Clients.AvailabilityClient;
import com.example.hotel.BookingService.rabbitmq.BookingProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class BookingService {
    private final AvailabilityClient availability;
    private final BookingProducer producer;

    @Value("${Name}")
    String name;

    @Value("${ID}")
    String id;

    public BookingService(AvailabilityClient availability,
                          BookingProducer producer) {
        this.availability = availability;
        this.producer     = producer;
    }
}

