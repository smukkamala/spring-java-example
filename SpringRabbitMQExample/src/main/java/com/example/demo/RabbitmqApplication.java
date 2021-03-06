package com.example.demo;

import com.example.demo.handler.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RabbitmqApplication {

    public static final String MESSAGE_QUENE = "TestQueue2";
    public final static String EXCHANGE_NAME = "TestExchange";

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }


    @GetMapping("/Main")
    public String main() throws InterruptedException {
        sender.send();
        return "hello world";
    }
}
