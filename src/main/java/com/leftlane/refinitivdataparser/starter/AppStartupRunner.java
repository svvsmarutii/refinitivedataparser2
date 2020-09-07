package com.leftlane.refinitivdataparser.starter;

import com.leftlane.refinitivdataparser.service.LGDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    LGDFService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Request received to parse usafull_LGDF files");
        service.process();
    }
}