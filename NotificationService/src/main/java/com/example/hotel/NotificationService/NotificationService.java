package com.example.hotel.NotificationService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @RabbitListener(queues = "booking_queue_sarah_52_24489")
    public void onNewBooking(String bookingId) {
        System.out.println("Received new booking from 52_24489: " + bookingId);
    }
}
