package tally.rabbitmq.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

    public void receiveMessage(final String message) {
        log.info("Received <{}>", message);
    }
}
