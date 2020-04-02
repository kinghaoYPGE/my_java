package com.springboot.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    void fun1() {
        myService.fun1();
    }

    @Test
    void fun2() {
        myService.fun2();
    }

    @Test
    void fun3() {
        myService.fun3();
    }

    @Test
    void fun4() {
        myService.fun4();
    }
}