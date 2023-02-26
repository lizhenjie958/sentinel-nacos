package com.jie.sentinel;

import com.jie.client.ProviderClient;
import org.springframework.stereotype.Service;

@Service
public class FallbackSentinelConsumerServiceImpl implements ProviderClient {
    public String service() {
        return "系统繁忙，请稍后";
    }

    public String sayHello() {
        return "系统繁忙，请稍后";
    }
}
