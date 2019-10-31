package com.evol;

import com.evol.runner.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotAliThermConsoleApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IotAliThermConsoleApplication.class, args);
    }


    @Autowired
    private SubscribeService subscribeService;

    @Override
    public void run(String... args) throws Exception{
        System.out.println("CommandLine Start");
        subscribeService.handMessage();
        System.console().readLine();

    }
}
