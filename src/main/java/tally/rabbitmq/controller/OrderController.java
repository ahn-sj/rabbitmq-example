package tally.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tally.rabbitmq.messaging.MessageSender;

import java.util.Objects;

import static tally.rabbitmq.util.JsonUtils.*;

@RestController
public class OrderController {
    private final MessageSender messageSender;

    public OrderController(final MessageSender messageSender) {
        this.messageSender = Objects.requireNonNull(messageSender);
    }

    @PostMapping("/v1/orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        messageSender.send(toJson(order));

        return ResponseEntity.ok()
                .body("Order created successfully");
    }

    public static class Order {
        private Long orderId;
        private Long productId;

        public Order() {}

        public Long getOrderId() {
            return orderId;
        }

        public Long getProductId() {
            return productId;
        }
    }
}
