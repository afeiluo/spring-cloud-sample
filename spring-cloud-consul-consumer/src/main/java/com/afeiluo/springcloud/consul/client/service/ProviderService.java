package com.afeiluo.springcloud.consul.client.service;

/**
 * Created by qiaolinfei on 2020/4/7.
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "consul-provider", fallback = FeignFallBack.class)
public interface ProviderService {
    /**
     * hello服务
     *
     * @return hello
     */
    @RequestMapping("/description")
    String desc();
}