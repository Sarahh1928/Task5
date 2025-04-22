package com.example.hotel.BookingService.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static final String BOOKING_QUEUE = "booking_queue_sarah_52_24489";
    public static final String EXCHANGE = "sarah_52_24489";
    public static final String BOOKING_ROUTING = "booking_routing_sarah_52_24489";

    @Bean
    public Queue queue() {
        return new Queue(BOOKING_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BOOKING_ROUTING);
    }
}