package com.jie;

@org.apache.dubbo.config.annotation.Service
public class ProviderServiceImpl implements ProviderService {
    public String service() {
        return "Provider invoke";
    }
}
