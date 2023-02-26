package com.jie;

@org.apache.dubbo.config.annotation.Service //注解标记此类的方法暴露为dubbo接口
public class ConsumerServiceImpl implements ConsumerService {
    @org.apache.dubbo.config.annotation.Reference
    private ProviderService providerService;

    //dubbo接口实现内容
    public String service() {
        //远程调用
        String service = providerService.service();
        return "Consumer invoke |" + service ;
    }
}
