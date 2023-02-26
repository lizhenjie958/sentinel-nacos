package com.jie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service2Bootstrop {
    public static void main(String[] args) {
        SpringApplication.run(Service2Bootstrop.class, args);
    }

    @Autowired
    ConfigurableApplicationContext applicationContext;
    //通过value注解读取配置信息
    @Value("${common.name}")
    private String config1;

    @GetMapping("/configs")
    public String getConfigs() {
        //读取配置信息
//        return config1;
        return applicationContext.getEnvironment().getProperty("common.name");
    }

    @GetMapping(value = "/configs2")
    public String getConfigs2() {
        String name = applicationContext.getEnvironment().getProperty("common.name");
        String age = applicationContext.getEnvironment().getProperty("common.age");
        String address = applicationContext.getEnvironment().getProperty("common.address");
        String birthday = applicationContext.getEnvironment().getProperty("common.birthday");
        String fullname = applicationContext.getEnvironment().getProperty("common.fullname");
        return name + "+" + age + "+" + address + "+" + birthday + "+" + fullname;
    }
}
