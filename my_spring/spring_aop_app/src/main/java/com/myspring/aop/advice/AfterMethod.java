package com.myspring.aop.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AfterMethod implements AfterReturningAdvice {

    // After Advice
    public void afterReturning(Object returnValue, Method method, Object[] args,
            Object target)
            throws Throwable {
        System.out.println("AfterMethod : After method executed!");

    }

}