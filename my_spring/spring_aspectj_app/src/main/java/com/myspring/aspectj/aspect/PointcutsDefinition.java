package com.myspring.aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsDefinition {

    @Pointcut("execution(public * com.myspring.aspectj.dao.CustomerDao.*(..))")
    public void customerLog() {
    }
}