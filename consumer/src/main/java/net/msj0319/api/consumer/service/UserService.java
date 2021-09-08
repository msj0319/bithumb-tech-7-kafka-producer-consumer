package net.msj0319.api.consumer.service;

import lombok.RequiredArgsConstructor;
import net.msj0319.api.consumer.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserService {
    @KafkaListener(topics = "kafka-spring-producer", containerFactory = "userKafkaListenerFactory")
    public void listenHeaders(
        @Payload User user,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: \n" + user + "\n" + "from partition " + partition);
    }
}