package com.leftlane.refinitivdataparser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RefinitivdataparserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefinitivdataparserApplication.class, args);
        log.info("APPLICATION Refinitiv data parser STARTED");
    }
}