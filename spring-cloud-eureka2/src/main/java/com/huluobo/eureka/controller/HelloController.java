package com.huluobo.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("HelloController.class");

    @Autowired
    private DiscoveryClient client;

    public String index () {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello world";
    }
}
