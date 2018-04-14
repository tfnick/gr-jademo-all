package com.gr.kafka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/kafkaSendMessage")
    public void sendTest() throws InterruptedException {
        System.out.println("send send data start");
        for (int i = 0; i < 5; i++) {

            kafkaTemplate.send("wks-wordcount-example-topic",
                    "{mock data i:  " + i + "  " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "}");
            Thread.sleep(200);
        }
        System.out.println("send send data end");
    }
}