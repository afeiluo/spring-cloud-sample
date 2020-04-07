package com.afeiluo.springcloud.consul.client.service;

import org.springframework.stereotype.Component;

/**
 * Created by qiaolinfei on 2020/4/7.
 */
@Component
public class FeignFallBack implements ProviderService {
    public String desc() {
        return "服务请求失败了";
    }
}
