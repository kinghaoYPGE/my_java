package com.myspring.aop.advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMethod implements MethodBeforeAdvice {

    // Before Advice
    public void before(Method arg0, Object[] args, Object target)
            throws Throwable {
        System.out.println("BeforeMethod : Before method executed!");

    }

}