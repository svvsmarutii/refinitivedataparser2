package com.leftlane.refinitivdataparser.controller;

import com.leftlane.refinitivdataparser.service.LGDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class LGDFController {

    @Autowired
    LGDFService service;

  /*  @GetMapping("/processLGDF")
    public ResponseEntity<String> start() {
        log.info("Request received to parse usafull_LGDF files");
        service.process();
        return new ResponseEntity<String>("Refinitiv Data for LGDF FULL parsing triggered - Async", HttpStatus.OK);
    }*/
}