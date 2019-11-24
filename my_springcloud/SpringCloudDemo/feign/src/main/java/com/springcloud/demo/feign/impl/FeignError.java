package com.springcloud.demo.feign.impl;

import com.springcloud.demo.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection findAll() {
        return null;
    }

    @Override
    public String index() {
        return "页面走丢了:)";
    }
}
