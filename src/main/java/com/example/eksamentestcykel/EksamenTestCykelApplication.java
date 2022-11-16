package com.example.eksamentestcykel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EksamenTestCykelApplication {

    private static final Logger log = LoggerFactory.getLogger(EksamenTestCykelApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EksamenTestCykelApplication.class, args);
    }


}
