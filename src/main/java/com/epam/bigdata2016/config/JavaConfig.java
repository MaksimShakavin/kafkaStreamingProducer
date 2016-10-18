package com.epam.bigdata2016.config;

import com.epam.bigdata2016.files.LogReader;
import com.epam.bigdata2016.producer.LogProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class JavaConfig {

    @Bean
    public LogReader logReader(AppProperties props){
        System.out.println(props.getData().getDirectory());
        return new LogReader(props.getData().getDirectory());
    }

    @Bean
    public LogProducer logProducer(KafkaProducer<String,String> kafkaProducer, AppProperties props){
        return new LogProducer(kafkaProducer,props.getData().getTopic());
    }

    @Bean
    @Scope("prototype")
    public KafkaProducer<String, String> kafkaProducer(AppProperties props){
        return new KafkaProducer<String, String>(props.getKafka().asMap());
    }

}
