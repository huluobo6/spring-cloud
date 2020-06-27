package com.huluobo.eureka.client.controller;

import com.huluobo.eureka.client.service.HelloService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;



@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger("ConsumerController.class");

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }
}
