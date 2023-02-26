package com.jie.client;

import com.jie.sentinel.FallbackSentinelConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="provider", fallback = FallbackSentinelConsumerServiceImpl.class)
public interface ProviderClient {
    @GetMapping("service")
    String service();

    @GetMapping("/sayHello")
    String sayHello();
}
