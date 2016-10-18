package com.epam.bigdata2016;

import com.epam.bigdata2016.files.LogReader;
import com.epam.bigdata2016.producer.LogProducer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@ComponentScan
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Main.class).run(args);
        LogReader reader=  ctx.getBean(LogReader.class);

        try(LogProducer producer = ctx.getBean(LogProducer.class)){
            reader.forEachLine(producer::send);
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }

    }
}
