package com.jie;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;

import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class SimpleDemoMain {
    public static void main(String[] args) throws Exception {
        String serverAddr = "127.0.0.1:8848";   // nacos地址
        String dataId = "testTextConfig";
        String group = "DEFAULT_GROUP"; // 默认组
        String namespace = "3d3a6d75-f83b-4ccb-a77f-6ef670f68ad3"; //开发环境
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        //  添加监听String dataId, String group, Listener listener
        configService.addListener(dataId, group, new Listener() {
            public Executor getExecutor() {
                return null;
            }

            //当配置发生变化时的响应
            public void receiveConfigInfo(String configInfo) {
                System.out.println(configInfo);
            }
        });

        // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出。 正式代码中无需下面代码
        while (true){
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
