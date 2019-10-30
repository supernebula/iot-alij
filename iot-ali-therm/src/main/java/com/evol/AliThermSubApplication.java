package com.evol;


import com.evol.runner.SubscribeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliThermSubApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(AliThermSubApplication.class);

    @Autowired
    SubscribeService subscribeService;

    public static void main(String args) {
        SpringApplication.run(AliThermSubApplication.class, args);
    }

    public void run(String... args) throws Exception {

        System.out.println("CommandLine Start");
        subscribeService.handMessage();
        System.console().readLine();

    }
}
