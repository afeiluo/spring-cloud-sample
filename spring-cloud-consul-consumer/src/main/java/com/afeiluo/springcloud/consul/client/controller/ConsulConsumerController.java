package com.afeiluo.springcloud.consul.client.controller;

/**
 * Created by qiaolinfei on 2020/4/7.
 */

import com.afeiluo.springcloud.consul.client.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsulConsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/desc")
    public String getDescInfo() {
        return providerService.desc();
    }
}