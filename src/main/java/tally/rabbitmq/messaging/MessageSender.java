package tally.rabbitmq.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static tally.rabbitmq.config.RabbitMQConfig.DEFAULT_QUEUE_NAME;

@Component
public class MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = Objects.requireNonNull(rabbitTemplate);
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(DEFAULT_QUEUE_NAME, message);
        logger.info("Sent <{}>", message);
    }
}
