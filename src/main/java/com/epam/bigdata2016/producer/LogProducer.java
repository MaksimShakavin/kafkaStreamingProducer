package com.epam.bigdata2016.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Closeable;
import java.io.IOException;


public class LogProducer implements Closeable{

    private KafkaProducer<String, String> kafkaProducer;
    private String topicName;

    public LogProducer(KafkaProducer<String, String> kafkaProducer, String topicName) {
        this.kafkaProducer = kafkaProducer;
        this.topicName = topicName;
    }

    public void send(String logLine){
        kafkaProducer.send(new ProducerRecord<String, String>(topicName,logLine));
    }

    @Override
    public void close() throws IOException {
        kafkaProducer.close();
    }
}
