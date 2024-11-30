package ru.mokinnart.skillbox.mod6.orderservice.listener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class OrderStatusListener {
    @KafkaListener(topics = "order-status-topic", groupId = "order-service-group")
    public void listenOrderStatus(ConsumerRecord<String, String> record) {
        log.info("Received message: {}", record.value());
        log.info("Key: {}; Partition: {}; Topic: {}, Timestamp: {}",
                record.key(), record.partition(), record.topic(), record.timestamp());
    }
}