package com.springcloud.demo.feign;

import com.springcloud.demo.view.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll")
    List<Menu> findAll();
}
