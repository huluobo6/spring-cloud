package com.huluobo.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.Logger;



@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("HelloController.class");

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index () throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();

        // 让处理线程等待一会
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);

        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello world";
    }
}
