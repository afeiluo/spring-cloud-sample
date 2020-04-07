package com.afeiluo.springcloud.consul.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaolinfei on 2020/4/7.
 */
@RefreshScope
@RestController
@EnableScheduling  //启用后，会定时拉取配置
@EnableConfigurationProperties({StudentConfig.class})
public class ConsulProviderController {
    //默认值是 zy
    @Value("${description:zy}")
    private String description;

    @Autowired
    private StudentConfig studentConfig;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/home")
    public String home() {
        return "this is consul service provider";
    }

    @RequestMapping("/description")
    public String testDescription() {
        return description;
    }

    @RequestMapping("/student")
    public String getStudent() {
        return studentConfig.toString();
    }
}
