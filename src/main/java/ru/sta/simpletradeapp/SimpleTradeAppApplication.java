package ru.sta.simpletradeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SimpleTradeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTradeAppApplication.class, args);
    }

}
