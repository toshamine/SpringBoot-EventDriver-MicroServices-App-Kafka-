package dev.chiba.emailservice.Service;

import dev.chiba.basedomainsservice.Dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {


    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        System.out.println(orderEvent.getMessage());
    }
}
