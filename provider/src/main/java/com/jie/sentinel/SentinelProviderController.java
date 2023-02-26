package com.jie.sentinel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelProviderController {

    @GetMapping("sayHello")
    public String sayHello(){
        return "provider sayHello";
    }
}
