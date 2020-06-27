package com.huluobo.eureka.client.controller;

import com.huluobo.eureka.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;



@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger("ConsumerController.class");

    @Autowired
    HelloService helloService;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer () {
        return helloService.helloService();
    }
}
