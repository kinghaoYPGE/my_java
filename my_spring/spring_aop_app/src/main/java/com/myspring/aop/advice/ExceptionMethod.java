package com.myspring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionMethod implements ThrowsAdvice {

    // Exception Advice
    public void afterThrowing(IllegalArgumentException e)
            throws Throwable {
        System.out.println("ExceptionMethod : Excetpion method executed!");

    }

}