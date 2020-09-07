package com.leftlane.refinitivdataparser.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @Autowired
    private ApplicationContext appContext;


    public void longRunning() throws InterruptedException {
        boolean flag = true;
        long curr = System.currentTimeMillis();
        for (int i = 0; i <= 12; i++) {
            System.out.println("FOR LOOP RUNNING " + (i + 1) + " th time");
            Thread.sleep(5000);
        }
        System.out.println("PROCESS DONE IN :  " + (System.currentTimeMillis() - curr));
    }


    public void longRunning2() throws InterruptedException {
        boolean flag = true;
        long curr = System.currentTimeMillis();
        for (int i = 0; i < 12; i++) {
            System.out.println("ANOTHER FOR LOOP RUNNING " + i + 1 + " th time");
            Thread.sleep(5000);
        }
        System.out.println("PROCESS 2 DONE IN :  " + (System.currentTimeMillis() - curr));
    }

        public void initiateShutdown(int returnCode){
            System.out.println("Request received to shut down spring boot application");
            SpringApplication.exit(appContext, () -> returnCode);
        }
}
