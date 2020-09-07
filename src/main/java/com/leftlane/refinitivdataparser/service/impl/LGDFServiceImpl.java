package com.leftlane.refinitivdataparser.service.impl;

import com.leftlane.refinitivdataparser.repository.CRCRepository;
import com.leftlane.refinitivdataparser.repository.entities.CrossRefCodes;
import com.leftlane.refinitivdataparser.service.LGDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Slf4j
@Service
public class LGDFServiceImpl implements LGDFService {

    @Autowired
    CRCRepository crcRepository;

    @Value("${file.path}")
    private String filePath;

    @Autowired
    DummyService dummyService;

    @Async
    @Override
    public void process() {
        try {

            System.out.println("Attempting to read data from DB");
            List<CrossRefCodes> crossRefCodes = crcRepository.findByStatus(Boolean.TRUE);
            System.out.println("number of records fetched : " + crossRefCodes.size());

            System.out.println("Attempting to read data from file");
            readFile(filePath);

            dummyService.longRunning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            dummyService.initiateShutdown(0);
        }
    }

    private void readFile(String filePath) {
        BufferedReader br = null;
        String line = "";
        int i = 1;
        try {
            br = new BufferedReader(new FileReader(filePath));
            System.out.println("try to read first 4 lines in the file ");
            while ((line = br.readLine()) != null) {
                System.out.println("line " + i + " : " + line);
                i++;
                if (i == 5) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}