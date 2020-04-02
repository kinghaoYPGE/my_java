package com.springboot.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopHandler {

    /* 声明切点 */
//    @Pointcut(value = "execution(* com.springboot.demo.service..*.fun*(..))")
//    public void aop(){}
    @Pointcut(value = "execution(* com.springboot.demo.service..*.fun1(..))")
    public void aop1(){}

    @Pointcut(value = "execution(* com.springboot.demo.service..*.fun2(..))")
    public void aop2(){}

    @Pointcut(value = "execution(* com.springboot.demo.service..*.fun3(..))")
    public void aop3(){}

    @Pointcut(value = "execution(* com.springboot.demo.service..*.fun4(..))")
    public void aop4(){}

    /* 前置通知 */
    @Before("aop1()")
    public void before() {
        System.err.println("前置通知：com.springboot.demo.aop.AopHandler.before");
    }

    /* 后置通知 */
    @After("aop1()")
    public void after() {
        System.err.println("后置通知：com.springboot.demo.aop.AopHandler.after");
    }

    /* 异常通知 */
    @AfterThrowing("aop4()")
    public void afterThrowing() {
        System.err.println("异常通知：com.springboot.demo.aop.AopHandler.afterThrowing");
    }

    /* 返回通知 */
    @AfterReturning("aop3()")
    public void afterReturning() {
        System.err.println("返回通知：com.springboot.demo.aop.AopHandler.afterReturning");
    }

    /* 环绕通知 */
    @Around("aop2()")
    public void around(ProceedingJoinPoint joinPoint){

        System.err.println("环绕通知前：com.springboot.demo.aop.AopHandler.around");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.err.println("环绕通知后：com.springboot.demo.aop.AopHandler.around");

    }



}
