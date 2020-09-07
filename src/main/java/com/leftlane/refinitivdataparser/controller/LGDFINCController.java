package com.leftlane.refinitivdataparser.controller;

import com.leftlane.refinitivdataparser.service.LGDFINCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/")
public class LGDFINCController {
    @Autowired
    LGDFINCService service;

   /* @GetMapping("/processLGDFINC")
    public ResponseEntity<String> start() throws ExecutionException, InterruptedException {
        log.info("Request received to parse LGDF INC files");
        service.process();
        return new ResponseEntity<String>("Refinitiv Data for LGDF INC parsing triggered - Async", HttpStatus.OK);
    }*/
}
