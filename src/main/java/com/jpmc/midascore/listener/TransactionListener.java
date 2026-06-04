package com.jpmc.midascore.listener;

import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private static final Logger log = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
       log.info("=== RECEIVED TRANSACTION === Amount: {} | From: {} | To: {}", 
                 transaction.getAmount(), 
                 transaction.getFromId(), 
                 transaction.getToId());
        // For now, just receive — no further processing needed
    }
}