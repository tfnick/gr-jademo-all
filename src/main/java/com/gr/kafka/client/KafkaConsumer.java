package com.gr.kafka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2018/4/8.
 */
@Service
public class KafkaConsumer {
    protected static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * 监听方法 异步方法
     * @param message
     */
    @KafkaListener(topics = {"wks-wordcount-example-topic"})
    public void consumer(String message) {
        logger.info("consumer test topic message : {}", message);
    }
}
