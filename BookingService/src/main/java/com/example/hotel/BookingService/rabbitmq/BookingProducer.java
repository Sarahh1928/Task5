package com.example.hotel.BookingService.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Value("${Name}")
    private String name;

    @Value("${ID}")
    private String id;

    public void sendBooking(String bookingId) {
        String message = bookingId;
        rabbitTemplate.convertAndSend(
                rabbitMQConfig.EXCHANGE,
                rabbitMQConfig.BOOKING_ROUTING,
                message
        );
        System.out.println("Sent from " + id + ": " + message);
    }
}