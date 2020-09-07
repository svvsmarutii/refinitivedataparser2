package com.leftlane.refinitivdataparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RefinitivdataparserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefinitivdataparserApplication.class, args);
        log.info("APPLICATION Refinitivdataparser STARTED");
    }
    
}
