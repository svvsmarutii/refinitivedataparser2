package com.leftlane.refinitivdataparser.service.impl;

import com.leftlane.refinitivdataparser.repository.CRCRepository;
import com.leftlane.refinitivdataparser.repository.entities.CrossRefCodes;
import com.leftlane.refinitivdataparser.service.LGDFINCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LGDFINCServiceImpl implements LGDFINCService {

    @Autowired
    CRCRepository crcRepository;

    @Autowired
    DummyService dummyService;

    @Async
    @Override
    public void process() {
        try {
            System.out.println("Attempting to read data from DB");
            List<CrossRefCodes> crossRefCodes = crcRepository.findByStatus(Boolean.TRUE);
            System.out.println("number of records fetched : " + crossRefCodes.size());

            dummyService.longRunning2();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            dummyService.initiateShutdown(0);
        }
    }
}
