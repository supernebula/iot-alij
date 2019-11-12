package com.evol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CmdSyncConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Hello Springboot!");
        SpringApplication.run(CmdSyncConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
