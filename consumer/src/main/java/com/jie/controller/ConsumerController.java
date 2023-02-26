package com.jie.controller;

import com.jie.client.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private ProviderClient providerClient;

    @GetMapping("service")
    public String service(){
        String service = providerClient.service();
        return "consumer invoke" + "   |  " + service;
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        return providerClient.sayHello();
    }
}
